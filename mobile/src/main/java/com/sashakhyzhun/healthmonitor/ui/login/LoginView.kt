package com.sashakhyzhun.healthmonitor.ui.login

import com.facebook.AccessToken
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.sashakhyzhun.healthmonitor.ui.base.MvpView

interface LoginView : MvpView {

    fun onClickLoginWithGoogle()
    fun onClickLoginWithFacebook()

    fun onSuccessGoogleLogin(account: GoogleSignInAccount)

    fun redirectUser()

}