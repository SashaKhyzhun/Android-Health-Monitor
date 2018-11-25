package com.sashakhyzhun.healthmonitor.ui.splash.login

import android.net.Uri
import com.facebook.AccessToken
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.sashakhyzhun.healthmonitor.ui.base.MvpPresenter

interface LoginPresenter<V : LoginView> : MvpPresenter<V> {

    fun signInGoogle()
    fun signInFacebook()

    fun handleGoogleLogin(account: GoogleSignInAccount)
    fun handleFacebookLogin(currentAccessToken: AccessToken)

    fun createNewUser(name: String, email: String, phone: String, photo: Uri?)

}