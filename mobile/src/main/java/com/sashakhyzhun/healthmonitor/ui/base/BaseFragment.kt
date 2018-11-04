package com.sashakhyzhun.healthmonitor.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.sashakhyzhun.healthmonitor.di.component.ActivityComponent
import com.sashakhyzhun.healthmonitor.utils.common.ActivityUtils
import com.sashakhyzhun.healthmonitor.utils.common.KeyboardUtils

abstract class BaseFragment : Fragment(), MvpView {

    private var mActivity: BaseActivity? = null
    private lateinit var mProgressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity: BaseActivity = context
            this.mActivity = activity
            //activity.onFragmentAttached()
        }
    }


    fun getActivityComponent(): ActivityComponent? {
        mActivity?.let {
            return it.getActivityComponent()
        }
        return null
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = ActivityUtils.showLoadingDialog(context!!)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing) {
            mProgressDialog.cancel()
        }
    }

    override fun onError(resId: Int) {
        mActivity?.let {
            onError(getString(resId))
        }
    }

    override fun onError(message: String) {
        mActivity?.let {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun showMessage(message: String) {
        mActivity?.let {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun showMessage(resId: Int) {
        mActivity?.let {
            showMessage(getString(resId))
        }
    }

    override fun hideKeyboard() {
        mActivity?.let {
            KeyboardUtils.hideSoftInput(it)
        }
    }

    protected abstract fun setUpView(view: View)


//    interface Callback {
//        fun onFragmentAttached()
//    }

}