package com.sashakhyzhun.healthmonitor.ui.profile.settings

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.*
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.ui.base.BaseActivity
import com.sashakhyzhun.healthmonitor.utils.builder.CustomUI
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
            showDialogUnits(this)
        }


        findViewById<TextView>(R.id.tvSendFeedback).setOnClickListener {
            onSendFeedback(this)
        }

        findViewById<TextView>(R.id.tvAbout).setOnClickListener {
            onShowDialogAbout(this)
        }

        findViewById<TextView>(R.id.tvMoreApps).setOnClickListener {
            onShowMoreApp()
        }
        findViewById<TextView>(R.id.tvShare).setOnClickListener {
            shareTheApp()
        }
        findViewById<TextView>(R.id.tvRateTheApp).setOnClickListener {
            redirectToRateTheApp()
        }

    }


    private fun showDialogUnits(activity: Activity) {
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

    private fun onSendFeedback(ctx: Context) {
        val dialog = CustomUI.createDialog(ctx, R.layout.custom_dialog_menu_send_feedback)

        dialog.findViewById<Button>(R.id.button_cancel).setOnClickListener { dialog.dismiss() }
        dialog.findViewById<Button>(R.id.button_send).setOnClickListener { _ ->
            val etFeedback = dialog.findViewById<EditText>(R.id.edit_text_feedback)
            if (etFeedback.text.toString().trim { it <= ' ' }.isNotEmpty()) {

                val email = Intent(Intent.ACTION_SENDTO).also {
                    it.data = Uri.parse("mailto:")
                    it.putExtra(Intent.EXTRA_EMAIL, recipients)
                    it.putExtra(Intent.EXTRA_SUBJECT, "Wear Todo | Feedback")
                    it.putExtra(Intent.EXTRA_TEXT, etFeedback.text.toString())
                }
                try {
                    startActivity(
                            Intent.createChooser(email, "Choose an email client from..."))
                } catch (ex: android.content.ActivityNotFoundException) {
                }
            }
        }

        dialog.show()
    }

    private fun onShowDialogAbout(ctx: Context) {
        val dialog = CustomUI.createDialog(ctx, R.layout.custom_dialog_menu_about)
        dialog.findViewById<Button>(R.id.btn_dialog).setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    private fun onShowMoreApp() {
        val goToMarket = CustomUI.generateIntent(Intent.ACTION_VIEW, null, Uri.parse(linkToProfile))
        startActivity(goToMarket)
    }

    private fun shareTheApp() {
        val sendIntent = CustomUI
                .generateIntent(Intent.ACTION_SEND, "text/plain", null)
                .also { it.putExtra(Intent.EXTRA_TEXT, shareText) }

        startActivity(sendIntent)

    }

    private fun redirectToRateTheApp() {
        val goToMarket = CustomUI.generateIntent(Intent.ACTION_VIEW, null,
                Uri.parse("$marketPrefix${this.packageName}")
        )
        startActivity(goToMarket)

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

    companion object {
        private val recipients = arrayOf("sasha.khyzhun@gmail.com")

        private const val marketPrefix = "market://details?id="
        private const val linkToProfile = "https://play.google.com/store/apps/dev?id=8830469597398237532"
        private const val shareText = "Health Monitor\nI'm getting healthy with my phone & watch\nFree on Play Market: goo.gl/xSx7HT"
    }


}