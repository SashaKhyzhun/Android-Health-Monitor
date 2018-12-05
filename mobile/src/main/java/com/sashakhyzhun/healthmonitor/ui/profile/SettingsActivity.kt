package com.sashakhyzhun.healthmonitor.ui.profile

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.widget.*
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.prefs.SessionManager
import com.sashakhyzhun.healthmonitor.ui.splash.LoginActivity
import com.sashakhyzhun.healthmonitor.utils.builder.CustomUI


class SettingsActivity : AppCompatActivity() {

    /**
     * Items:
     *
     * Connectivity to wear
     * Connectivity with Google Fit
     * Units
     *
     */

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var gso: GoogleSignInOptions
    private lateinit var sessionManager: SessionManager

    private lateinit var rbCentimeters: RadioButton
    private lateinit var rbFeetAndInches: RadioButton
    private var isSelectedCentimeters = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        firebaseAuth = FirebaseAuth.getInstance()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        sessionManager = SessionManager(this)

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

        findViewById<TextView>(R.id.tvLogout).setOnClickListener {
            showLogoutDialog(this)
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
                    it.putExtra(Intent.EXTRA_SUBJECT, "HealthMonitor | Feedback")
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

    private fun showLogoutDialog(activity: Activity) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Attention")
        dialog.setMessage("Are you sure you want to log out?")
        dialog.setPositiveButton("Yes") { _, _ ->
            signOutFacebook()
            signOutGoogle()
            sessionManager.clearUserSession()
            startActivity(Intent(activity, LoginActivity::class.java))
        }
        dialog.setNeutralButton("Cancel") { alert, _ ->
            alert.dismiss()
        }

        dialog.show()

    }

    private fun signOutGoogle() {
        firebaseAuth.signOut()
        mGoogleSignInClient.signOut()
    }

    private fun signOutFacebook() {
        LoginManager.getInstance().logOut()
    }

    companion object {
        private val recipients = arrayOf("sasha.khyzhun@gmail.com")

        private const val marketPrefix = "market://details?id="
        private const val linkToProfile = "https://play.google.com/store/apps/dev?id=8830469597398237532"
        private const val shareText = "Health Monitor\nI'm getting healthy with my phone & watch\nFree on Play Market: goo.gl/xSx7HT"
    }


}