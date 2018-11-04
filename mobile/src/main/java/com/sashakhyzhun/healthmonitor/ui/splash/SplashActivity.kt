package com.sashakhyzhun.healthmonitor.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.AppDataManager
import com.sashakhyzhun.healthmonitor.di.component.AppComponent
import com.sashakhyzhun.healthmonitor.di.module.AppModule
import com.sashakhyzhun.healthmonitor.ui.MainActivity
import com.sashakhyzhun.healthmonitor.ui.base.BaseActivity
import com.sashakhyzhun.healthmonitor.ui.login.LoginActivity
import timber.log.Timber
import javax.inject.Inject


class SplashActivity : BaseActivity() {

    lateinit var dm: AppDataManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        getActivityComponent().inject(this)

        Timber.d("called")



        Timber.d("is new user =${dm.isNewUser()}")

        Handler().postDelayed({
            performRedirection()
        }, 1000)


    }


    private fun performRedirection() {
        if (dm.isNewUser()) { // first time is not.
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}