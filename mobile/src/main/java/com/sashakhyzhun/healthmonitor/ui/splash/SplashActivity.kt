package com.sashakhyzhun.healthmonitor.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.AppDataManager
import com.sashakhyzhun.healthmonitor.data.prefs.IPreferencesHelper
import com.sashakhyzhun.healthmonitor.data.prefs.PreferencesHelper
import com.sashakhyzhun.healthmonitor.ui.MainActivity
import com.sashakhyzhun.healthmonitor.ui.login.LoginActivity
import timber.log.Timber
import com.google.android.gms.common.util.IOUtils.toByteArray
import android.content.pm.PackageManager
import android.content.pm.PackageInfo
import android.util.Base64
import android.util.Log
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class SplashActivity : AppCompatActivity() {

    private lateinit var dm: AppDataManager
    private lateinit var prefs: IPreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Timber.d("called")

        prefs = PreferencesHelper(this)
        dm = AppDataManager(this, prefs)

        Timber.d("isRegisteredUser=${dm.isRegisteredUser()}")

        Handler().postDelayed({
            performRedirection()
        }, 1000)


    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    // running

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    private fun performRedirection() {
        if (dm.isRegisteredUser()) { // first time is not.
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}