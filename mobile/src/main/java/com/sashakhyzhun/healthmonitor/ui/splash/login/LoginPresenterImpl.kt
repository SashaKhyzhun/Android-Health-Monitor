package com.sashakhyzhun.healthmonitor.ui.splash.login

import android.net.Uri
import android.os.Bundle
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.sashakhyzhun.healthmonitor.data.AppDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import org.json.JSONException
import timber.log.Timber
import javax.inject.Inject

class LoginPresenterImpl<V : LoginView> @Inject constructor(
        mDataManager: AppDataManagerHelper
) : BasePresenter<V>(mDataManager), LoginPresenter<V> {

    override fun signInGoogle() {
        mMvpView?.onClickLoginWithGoogle()
    }

    override fun signInFacebook() {
        mMvpView?.onClickLoginWithFacebook()
    }

    override fun handleGoogleLogin(account: GoogleSignInAccount) {
        mMvpView?.onSuccessGoogleLogin(account)
    }

    override fun handleFacebookLogin(currentAccessToken: AccessToken) {
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

    override fun createNewUser(name: String, email: String, phone: String, photo: Uri?,
                               height: Int, weight: Int, birthday: String) {

        mMvpView?.apply {
            mDataManager.setIsNewUser(false)
            Timber.d("isNewUser=${mDataManager.isNewUser()}")
            mDataManager.createUserSession(name = name, email = email, phone = phone,
                    photo = photo!!, height = height, weight = weight, birthday = birthday)
            redirectUser()
        }
    }
}