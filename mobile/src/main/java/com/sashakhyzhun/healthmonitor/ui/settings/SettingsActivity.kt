package com.sashakhyzhun.healthmonitor.ui.settings

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.ui.base.BaseActivity
import javax.inject.Inject

class SettingsActivity : BaseActivity(), SettingsView {

    /**
     * Items:
     *
     * Connectivity to wear
     * Connectivity with Google Fit
     * Units
     *
     */

    @Inject
    lateinit var presenter: SettingsPresenter<SettingsView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        val component = getActivityComponent()
        component.let {
            it.inject(this)
            presenter.onAttach(this)
        }

    }



}