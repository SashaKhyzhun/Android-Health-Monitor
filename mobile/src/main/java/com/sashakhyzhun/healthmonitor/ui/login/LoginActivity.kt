package com.sashakhyzhun.healthmonitor.ui.login

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.facebook.*
import com.facebook.login.widget.LoginButton

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.AppDataManager
import com.sashakhyzhun.healthmonitor.data.prefs.IPreferencesHelper
import com.sashakhyzhun.healthmonitor.data.prefs.PreferencesHelper
import com.sashakhyzhun.healthmonitor.ui.MainActivity

import timber.log.Timber
import com.facebook.login.LoginResult
import org.json.JSONException
import org.json.JSONObject


class LoginActivity : AppCompatActivity() {

    companion object {
        private const val RC_SIGN_IN = 9001
        private const val EMAIL = "email"

    }

    private var mAuth: FirebaseAuth? = null
    private var progressDialog: ProgressDialog? = null
    private var mGoogleSignInClient: GoogleSignInClient? = null

    private lateinit var facebookSignInButton: LoginButton
    private lateinit var callbackManager: CallbackManager
    private lateinit var prefs: IPreferencesHelper
    private lateinit var dm: AppDataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Timber.d("called")

        val googleSignInButton = findViewById<SignInButton>(R.id.sign_in_button)
        facebookSignInButton = findViewById(R.id.login_button)
        facebookSignInButton.setReadPermissions(listOf(EMAIL))
        callbackManager = CallbackManager.Factory.create()

        progressDialog = ProgressDialog(this)

        prefs = PreferencesHelper(this)
        dm = AppDataManager(this, prefs)

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        mAuth = FirebaseAuth.getInstance()

        googleSignInButton.setOnClickListener { signInGoogle() }
        facebookSignInButton.setOnClickListener { signInFacebook() }
    }


    private fun displayProgressDiaTimber() {
        progressDialog!!.setMessage("Logging In... Please wait...")
        progressDialog!!.isIndeterminate = false
        progressDialog!!.setCancelable(false)
        progressDialog!!.show()

    }

    private fun hideProgressDialog() {
        progressDialog!!.dismiss()
    }

    private fun signInGoogle() {
        val signInIntent = mGoogleSignInClient!!.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun signInFacebook() {
        // Callback registration
        facebookSignInButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                // App code
                val accessToken = AccessToken.getCurrentAccessToken()
                val isLoggedIn = accessToken != null && !accessToken.isExpired

                Timber.d("facebook login: $isLoggedIn")
                handleFacebookUser(accessToken)
            }

            override fun onCancel() {
                // App code
            }

            override fun onError(exception: FacebookException) {
                // App code
            }
        })
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Timber.i("Google sign in failed: $e")
            }
        } else {
            // facebook
            callbackManager.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        displayProgressDiaTimber()
        Timber.d("firebaseAuthWithGoogle:%s", acct.id!!)

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        mAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Timber.i("signInWithCredential:success")
                        val user = mAuth!!.currentUser

                        handleGoogleUser(user)

                    } else {
                        // If sign in fails, display a message to the user.
                        Timber.i("signInWithCredential:failure ${task.exception!!}")
                        Toast.makeText(applicationContext, "Failed: ", Toast.LENGTH_SHORT).show()
                    }

                    hideProgressDialog()
                }
    }

    private fun handleGoogleUser(user: FirebaseUser?) {
        hideProgressDialog()

        val name = user?.displayName ?: ""
        val email = user?.email ?: ""
        val number = user?.phoneNumber ?: ""
        val photo = user?.photoUrl ?: Uri.EMPTY

        createNewUser(name = name, email = email, phone = number, photo = photo)
    }

    private fun handleFacebookUser(currentAccessToken: AccessToken) {
        val request = GraphRequest.newMeRequest(currentAccessToken) { jsonObject, _ ->
            try {
                val firstName = jsonObject?.getString("first_name")
                val lastName = jsonObject?.getString("last_name")
                val email = jsonObject?.getString("email")
                val id = jsonObject?.getString("id")
                val imageUrl = "https://graph.facebook.com/$id/picture?type=normal"

                createNewUser("$firstName $lastName", email!!, "", Uri.parse(imageUrl))


            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }

        val parameters = Bundle()
        parameters.putString("fields", "first_name,last_name,email,id")
        request.parameters = parameters
        request.executeAsync()
    }

    private fun createNewUser(name: String, email: String, phone: String, photo: Uri) {
        dm.setIsRegisteredUser(true)
        Timber.d("isRegisteredUser=${dm.isRegisteredUser()}")
        dm.createUserSession(name = name, email = email, phone = phone, photo = photo)
        startActivity(Intent(this, MainActivity::class.java))
    }




}

