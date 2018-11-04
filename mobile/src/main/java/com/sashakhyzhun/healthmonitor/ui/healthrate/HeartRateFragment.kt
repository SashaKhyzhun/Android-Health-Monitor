package com.sashakhyzhun.healthmonitor.ui.healthrate

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.ui.base.BaseFragment
import javax.inject.Inject

class HeartRateFragment : BaseFragment(), HeartRateView {

    @Inject
    lateinit var presenter: HeartRatePresenter<HeartRateView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.heart_rate_fragment, container, false)

        val component = getActivityComponent()
        component?.let {
            it.inject(this)
            presenter.onAttach(this)
        }

        return view

    }

    override fun setUpView(view: View) {

    }
}