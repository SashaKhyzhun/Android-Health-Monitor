package com.sashakhyzhun.healthmonitor.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.sashakhyzhun.healthmonitor.HealthMonitor
import com.sashakhyzhun.healthmonitor.di.component.ActivityComponent
import com.sashakhyzhun.healthmonitor.di.component.DaggerActivityComponent
import com.sashakhyzhun.healthmonitor.di.module.ActivityModule
import com.sashakhyzhun.healthmonitor.utils.common.ActivityUtils
import com.sashakhyzhun.healthmonitor.utils.common.KeyboardUtils

abstract class BaseActivity : AppCompatActivity(), MvpView {

    private var mProgressDialog: ProgressDialog? = null

    private lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .appComponent((application as HealthMonitor).getComponent())
                .build()


    }

    fun getActivityComponent(): ActivityComponent = mActivityComponent

    override fun showLoading() {
        hideLoading()
        mProgressDialog = ActivityUtils.showLoadingDialog(this)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    override fun onError(resId: Int) {
        onError(getString(resId))
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(resId: Int) {
        showMessage(getString(resId))
    }

    override fun hideKeyboard() {
        KeyboardUtils.hideSoftInput(this)
    }


}