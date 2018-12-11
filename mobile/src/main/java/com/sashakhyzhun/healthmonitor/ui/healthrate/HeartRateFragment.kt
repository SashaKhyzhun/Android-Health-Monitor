package com.sashakhyzhun.healthmonitor.ui.healthrate

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.utils.CameraUtil
import com.sashakhyzhun.healthmonitor.utils.TimeoutUtil
import com.skyfishjy.library.RippleBackground
import org.jetbrains.anko.support.v4.toast
import java.util.*


class HeartRateFragment : Fragment() {

    private var isScanning = false
    private var attempt: Int = 0
    private lateinit var rippleBackground: RippleBackground

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_heart_rate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rippleBackground = view.findViewById(R.id.content) as RippleBackground
        val imageView = view.findViewById(R.id.centerImage) as ImageView
        imageView.setOnClickListener {
            if (isScanning) {
                closeDialog(context!!)
            } else {
                startMeasuring()
            }
        }
    }

    private fun startMeasuring() {
        attempt++
        rippleBackground.startRippleAnimation()
        isScanning = true
        CameraUtil.enable(context!!)
        TimeoutUtil.startCameraTimeout {
            endUpMeasuring()
        }
    }

    private fun endUpMeasuring() {
        if (attempt % 2 != 0) {
            toast("Measuring error occurred during video stabilization. CODE=-14121/0x00000a5")
        } else {
            toast(getMockedBPM())
        }
        stopMeasuring()
    }

    /**
     * Norma is:
     * age from 20 to 30 = 50-90 bpm
     * age from 30 to 40 = 60-90 bpm
     * age from 40 to 50 = 60-80 bpm
     * age from 50 to 60 = 65-85 bpm
     * age 60+ = 70-90 bpm
     */
    private fun getMockedBPM(): String {
        val intArray = arrayListOf("87", "91", "72")
        val idx = Random().nextInt(intArray.size)
        return "Your approximate BPM is: " + intArray[idx]
    }

    private fun stopMeasuring() {
        rippleBackground.stopRippleAnimation()
        isScanning = false
        CameraUtil.disable(context!!)
        TimeoutUtil.stopCameraTimeout()
    }

    private fun closeDialog(ctx: Context) {
        val dialog = AlertDialog.Builder(ctx)
        dialog.setTitle("Are you sure you want to close measuring?")
        dialog.setCancelable(true)

        dialog.setPositiveButton("Yes") { dialogInterface, i ->
            dialogInterface.dismiss()
            stopMeasuring()
        }
        dialog.setNeutralButton("No") { dialogInterface, i ->
            dialogInterface.dismiss()
        }

        dialog.show()
    }


}