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


class HeartRateFragment : Fragment() {

    private var isScanning = false
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
        rippleBackground.startRippleAnimation()
        isScanning = true
        CameraUtil.enable(context!!)
        TimeoutUtil.startCameraTimeout {
            stopMeasuring()
        }
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