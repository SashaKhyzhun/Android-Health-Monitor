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
import com.sashakhyzhun.healthmonitor.ui.settings.SettingsActivity
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity
import javax.inject.Inject

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


    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var mGoogleSignInClient: GoogleSignInClient

    // UI
    private lateinit var ivSettings: ImageView

    @Inject
    lateinit var gso: GoogleSignInOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        mGoogleSignInClient = GoogleSignIn.getClient(context!!, gso)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.profile_fragment, container, false)

        ivSettings = view.findViewById(R.id.ivSettings)
        ivSettings.onClick { startActivity<SettingsActivity>() }


        return view

    }


    private fun signOutGoogle() {
        firebaseAuth.signOut()
        mGoogleSignInClient.signOut()
    }

    private fun signOutFacebook() {
        LoginManager.getInstance().logOut()
    }


}