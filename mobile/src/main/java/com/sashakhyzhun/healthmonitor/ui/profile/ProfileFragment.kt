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
import com.sashakhyzhun.healthmonitor.ui.base.BaseFragment
import com.sashakhyzhun.healthmonitor.ui.settings.SettingsActivity
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity
import javax.inject.Inject

class ProfileFragment : BaseFragment(), ProfileView {

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
    private lateinit var ivSettings: ImageView

    @Inject
    lateinit var presenter: ProfilePresenter<ProfileView>

    private lateinit var gso: GoogleSignInOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val component = getActivityComponent()
        component?.let {
            it.inject(this)
            presenter.onAttach(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.profile_fragment, container, false)

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(activity?.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        firebaseAuth = FirebaseAuth.getInstance()
        mGoogleSignInClient = GoogleSignIn.getClient(context!!, gso)

        return view
    }


    private fun signOutGoogle() {
        firebaseAuth.signOut()
        mGoogleSignInClient.signOut()
    }

    private fun signOutFacebook() {
        LoginManager.getInstance().logOut()
    }

    override fun setUpView(view: View) {
        ivSettings = view.findViewById(R.id.ivSettings)
        ivSettings.onClick { startActivity<SettingsActivity>() }

    }
}