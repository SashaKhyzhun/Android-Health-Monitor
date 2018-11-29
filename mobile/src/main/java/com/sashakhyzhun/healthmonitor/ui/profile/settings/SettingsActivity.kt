package com.sashakhyzhun.healthmonitor.ui.profile.settings

import android.app.Dialog
import android.os.Bundle
import android.widget.LinearLayout
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.ui.base.BaseActivity
import javax.inject.Inject
import android.app.Activity
import android.view.Window
import android.widget.RadioButton


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

    private lateinit var rbCentimeters: RadioButton
    private lateinit var rbFeetAndInches: RadioButton
    private var isSelectedCentimeters = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val component = getActivityComponent()
        component.let {
            it.inject(this)
            presenter.onAttach(this)
        }


        val layoutHeight = findViewById<LinearLayout>(R.id.layout_height)
        val layoutWeight = findViewById<LinearLayout>(R.id.layout_weight)
        val layoutEnergy = findViewById<LinearLayout>(R.id.layout_energy)
        val layoutDistance = findViewById<LinearLayout>(R.id.layout_distance)

        layoutHeight.setOnClickListener {
            showDialog(this)
        }
    }


    fun showDialog(activity: Activity) {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.custom_dialog_units)

        rbCentimeters = dialog.findViewById(R.id.rbCentimeters) as RadioButton
        rbFeetAndInches = dialog.findViewById(R.id.rbFeetAndInches) as RadioButton

        updateRadioButtons(isSelectedCentimeters)

        rbCentimeters.setOnClickListener {
            isSelectedCentimeters = true
            updateRadioButtons(isSelectedCentimeters)
        }
        rbFeetAndInches.setOnClickListener {
            isSelectedCentimeters = false
            updateRadioButtons(isSelectedCentimeters)
        }


        dialog.show()

    }

    private fun updateRadioButtons(isSelectedCentimeters: Boolean) {
        if (isSelectedCentimeters) {
            rbCentimeters.isChecked = true
            rbFeetAndInches.isChecked = false
        } else {
            rbCentimeters.isChecked = false
            rbFeetAndInches.isChecked = true
        }
    }

}