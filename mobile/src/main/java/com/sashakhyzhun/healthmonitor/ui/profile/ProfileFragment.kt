package com.sashakhyzhun.healthmonitor.ui.profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.AppDataManager
import com.sashakhyzhun.healthmonitor.ui.profile.settings.SettingsActivity
import kotlinx.android.synthetic.main.profile_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity

class ProfileFragment : Fragment() {

    /**
     * Items:
     *
     * Name
     * Email
     * Photo
     * Gender
     * Date of birth
     * Height
     * Weight
     *
     * Blood
     * Allergy
     * Lifestyle
     *
     * Personal Goals:
     *
     */


    private lateinit var mAuth: FirebaseAuth
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var dataManager: AppDataManager

    // UI
    //private lateinit var ivSettings: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()


        mAuth = FirebaseAuth.getInstance()
        mGoogleSignInClient = GoogleSignIn.getClient(context!!, gso)



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.profile_fragment, container, false)








        ivSettings.onClick { startActivity<SettingsActivity>() }


        return view

    }


    private fun signOutGoogle() {
        mAuth!!.signOut() // Firebase sign out
        mGoogleSignInClient!!.signOut() // Google sign out
    }

    private fun signOutFacebook() {
        LoginManager.getInstance().logOut()
    }

}