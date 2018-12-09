package com.sashakhyzhun.healthmonitor.ui.healthrate

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.R.id.centerImage
import com.skyfishjy.library.RippleBackground



class HeartRateFragment : Fragment() {

    private var isScanning = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_heart_rate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rippleBackground = view.findViewById(R.id.content) as RippleBackground
        val imageView = view.findViewById(R.id.centerImage) as ImageView
        imageView.setOnClickListener {
            if (isScanning) {
                rippleBackground.stopRippleAnimation()
                isScanning = false
            } else {
                rippleBackground.startRippleAnimation()
                isScanning = true
            }
        }
    }


}