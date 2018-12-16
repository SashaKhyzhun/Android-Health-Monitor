package com.sashakhyzhun.healthmonitor.ui.main

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sashakhyzhun.healthmonitor.R

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        val image = findViewById<ImageView>(R.id.ivUserPhoto)
        Glide.with(this)
                .load(R.drawable.ic_my_profile)
                .apply(RequestOptions().circleCrop())
                .into(image)
    }
}
