package com.sashakhyzhun.healthmonitor.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.AppDataManager
import com.sashakhyzhun.healthmonitor.data.IDataManagerHelper
import com.sashakhyzhun.healthmonitor.di.component.AppComponent
import com.sashakhyzhun.healthmonitor.di.module.AppModule
import com.sashakhyzhun.healthmonitor.ui.MainActivity
import com.sashakhyzhun.healthmonitor.ui.base.BaseActivity
import com.sashakhyzhun.healthmonitor.ui.login.LoginActivity
import timber.log.Timber
import javax.inject.Inject


class SplashActivity : BaseActivity(), SplashView {

    @Inject
    lateinit var mPresenter: SplashPresenter<SplashView>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        val component = getActivityComponent()
        component.let {
            it.inject(this)
            mPresenter.onAttach(this)
        }


        mPresenter.redirectUserToNeededPage()
    }

    override fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun startLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

}