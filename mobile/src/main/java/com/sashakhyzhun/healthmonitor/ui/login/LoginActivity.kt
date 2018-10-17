package com.sashakhyzhun.healthmonitor.ui.login

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

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

class LoginActivity : AppCompatActivity() {

    companion object {
        private const val RC_SIGN_IN = 9001
    }

    private var mAuth: FirebaseAuth? = null
    private var progressDialog: ProgressDialog? = null
    private var mGoogleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Timber.d("called")


        val signInButton = findViewById<SignInButton>(R.id.sign_in_button)
        progressDialog = ProgressDialog(this)

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        mAuth = FirebaseAuth.getInstance()

        signInButton.setOnClickListener { signIn() }
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("called")
    }


    private fun displayProgressDiaTimber() {
        progressDialog!!.setMessage("Logging In... Please wait...")
        progressDialog!!.isIndeterminate = false
        progressDialog!!.setCancelable(false)
        progressDialog!!.show()

    }

    public override fun onStart() {
        super.onStart()
    }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient!!.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
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

                        handleUserCreating(user)

                    } else {
                        // If sign in fails, display a message to the user.
                        Timber.i("signInWithCredential:failure ${task.exception!!}")
                        Toast.makeText(applicationContext, "Failed: ", Toast.LENGTH_SHORT).show()
                    }

                    hideProgressDialog()
                }
    }

    private fun handleUserCreating(user: FirebaseUser?) {

        val prefs: IPreferencesHelper = PreferencesHelper(this)
        val dm = AppDataManager(this, prefs)

        hideProgressDialog()

        val name = user?.displayName ?: ""
        val email = user?.email ?: ""
        val number = user?.phoneNumber ?: ""
        val photo = user?.photoUrl ?: Uri.EMPTY

        dm.createUserSession(name = name, email = email, phone = number, photo = photo)
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun hideProgressDialog() {
        progressDialog!!.dismiss()
    }

}

