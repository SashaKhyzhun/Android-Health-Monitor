package com.sashakhyzhun.healthmonitor.ui.settings

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sashakhyzhun.healthmonitor.R

class SettingsActivity : AppCompatActivity() {

    /**
     * Items:
     *
     * Connectivity to wear
     * Connectivity with Google Fit
     * Units
     *
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
    }

}