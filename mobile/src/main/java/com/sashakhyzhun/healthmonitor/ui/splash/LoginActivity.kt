package com.sashakhyzhun.healthmonitor.ui.splash

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.facebook.*
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
import com.sashakhyzhun.healthmonitor.data.prefs.SessionManager
import com.sashakhyzhun.healthmonitor.ui.MainActivity
import org.json.JSONException
import timber.log.Timber


class LoginActivity : AppCompatActivity() {

    companion object {
        private const val RC_SIGN_IN = 9001
        private const val EMAIL = "email"

    }

    private var mAuth: FirebaseAuth? = null
    private var mGoogleSignInClient: GoogleSignInClient? = null

    private lateinit var facebookSignInButton: LoginButton
    private lateinit var callbackManager: CallbackManager

    private lateinit var session: SessionManager
    lateinit var gso: GoogleSignInOptions


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Timber.d("called")

        session = SessionManager(this)
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

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

        googleSignInButton.setOnClickListener { onClickLoginWithGoogle() }
        facebookSignInButton.setOnClickListener { onClickLoginWithFacebook() }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)

                onSuccessGoogleLogin(account!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Timber.i("Google sign in failed: $e")
            }
        } else {
            // facebook
            callbackManager.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun onClickLoginWithGoogle() {
        val signInIntent = mGoogleSignInClient!!.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun onClickLoginWithFacebook() {
        facebookSignInButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                handleFacebookLogin(AccessToken.getCurrentAccessToken())
            }

            override fun onCancel() {}
            override fun onError(exception: FacebookException) {}
        })
    }

    private fun onSuccessGoogleLogin(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        mAuth!!.signInWithCredential(credential).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Timber.i("signInWithCredential:success")
                val user = mAuth!!.currentUser


                val name = user?.displayName ?: ""
                val email = user?.email ?: ""
                val number = user?.phoneNumber ?: ""
                val photo = user?.photoUrl ?: Uri.EMPTY

                createNewUser(name = name, email = email, phone = number, photo = photo,
                        height = 179, weight = 76, birthday = "18.08.1996")

            } else {
                // If sign in fails, display a message to the user.
                Timber.e("signInWithCredential:failure ${task.exception!!}")
            }

        }
    }

    private fun handleFacebookLogin(currentAccessToken: AccessToken) {
        val request = GraphRequest.newMeRequest(currentAccessToken) { jsonObject, _ ->
            try {
                val firstName = jsonObject?.getString("first_name")
                val lastName = jsonObject?.getString("last_name")
                val email = jsonObject?.getString("email")
                val id = jsonObject?.getString("id")
                val imageUrl = "https://graph.facebook.com/$id/picture?type=normal"

                createNewUser("$firstName $lastName", email!!, "", Uri.parse(imageUrl),
                        179, 76, "18.08.1996")


            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }

        val parameters = Bundle()
        parameters.putString("fields", "first_name,last_name,email,id")
        request.parameters = parameters
        request.executeAsync()
    }

    private fun createNewUser(name: String, email: String, phone: String, photo: Uri?,
                               height: Int, weight: Int, birthday: String) {

        Timber.d("createNewUser | before isLoggedIn=${session.isLoggedIn}")
        session.createUserSession(name, email,  phone, photo!!, height, weight,  birthday)
        Timber.d("createNewUser | after isLoggedIn=${session.isLoggedIn}")

        startActivity(Intent(this, MainActivity::class.java))
    }

}

