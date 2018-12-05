package com.sashakhyzhun.healthmonitor.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.prefs.SessionManager
import com.sashakhyzhun.healthmonitor.ui.MainActivity
import timber.log.Timber


class SplashActivity : AppCompatActivity() {

    private lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        session = SessionManager(this)

        Timber.d("is logged in = ${session.isLoggedIn}")
        Handler().postDelayed({
            when(session.isLoggedIn) {
                true -> startMainActivity()
                false -> startLoginActivity()
            }
        }, 1000)
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun startLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

}