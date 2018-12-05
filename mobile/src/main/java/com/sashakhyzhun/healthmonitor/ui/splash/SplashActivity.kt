package com.sashakhyzhun.healthmonitor.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.prefs.SessionManager
import com.sashakhyzhun.healthmonitor.ui.MainActivity
import org.jetbrains.anko.toast
import timber.log.Timber


class SplashActivity : AppCompatActivity() {

    private lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        session = SessionManager(this)

        Timber.d("is new user = ${session.isNewUser}")
        Handler().postDelayed({
            when {
                session.isNewUser == "net" -> startMainActivity()
                session.isNewUser == "da" -> startLoginActivity()
                session.isNewUser == "first_login" -> startLoginActivity()
                else -> toast("ELSE BITCH")
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