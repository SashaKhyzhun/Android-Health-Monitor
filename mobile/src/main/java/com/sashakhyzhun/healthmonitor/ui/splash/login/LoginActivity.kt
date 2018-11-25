package com.sashakhyzhun.healthmonitor.ui.splash.login

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.ui.MainActivity
import com.sashakhyzhun.healthmonitor.ui.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject


class LoginActivity : BaseActivity(), LoginView {

    companion object {
        private const val RC_SIGN_IN = 9001
        private const val EMAIL = "email"

    }

    private var mAuth: FirebaseAuth? = null
    private var mGoogleSignInClient: GoogleSignInClient? = null

    private lateinit var facebookSignInButton: LoginButton
    private lateinit var callbackManager: CallbackManager

    @Inject
    lateinit var mPresenter: LoginPresenter<LoginView>
    @Inject
    lateinit var gso: GoogleSignInOptions


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Timber.d("called")

        val component = getActivityComponent()
        component.let {
            it.inject(this)
            mPresenter.onAttach(this)
        }

        // Permission for storage
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CALL_PHONE,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
        }

        val googleSignInButton = findViewById<SignInButton>(R.id.sign_in_button)
        facebookSignInButton = findViewById(R.id.login_button)
        facebookSignInButton.setReadPermissions(listOf(EMAIL))
        callbackManager = CallbackManager.Factory.create()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        mAuth = FirebaseAuth.getInstance()

        googleSignInButton.setOnClickListener { mPresenter.signInGoogle() }
        facebookSignInButton.setOnClickListener { mPresenter.signInFacebook() }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)

                mPresenter.handleGoogleLogin(account!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Timber.i("Google sign in failed: $e")
            }
        } else {
            // facebook
            callbackManager.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onClickLoginWithGoogle() {
        val signInIntent = mGoogleSignInClient!!.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onClickLoginWithFacebook() {
        facebookSignInButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                mPresenter.handleFacebookLogin(AccessToken.getCurrentAccessToken())
            }

            override fun onCancel() {}
            override fun onError(exception: FacebookException) {}
        })
    }

    override fun onSuccessGoogleLogin(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        mAuth!!.signInWithCredential(credential).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Timber.i("signInWithCredential:success")
                val user = mAuth!!.currentUser

                hideLoading()

                val name = user?.displayName ?: ""
                val email = user?.email ?: ""
                val number = user?.phoneNumber ?: ""
                val photo = user?.photoUrl ?: Uri.EMPTY

                mPresenter.createNewUser(name = name, email = email, phone = number, photo = photo)

            } else {
                // If sign in fails, display a message to the user.
                Timber.e("signInWithCredential:failure ${task.exception!!}")
            }
            hideLoading()
        }
    }

    override fun redirectUser() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}

