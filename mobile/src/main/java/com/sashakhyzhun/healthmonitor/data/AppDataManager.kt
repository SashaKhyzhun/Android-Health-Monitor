package com.sashakhyzhun.healthmonitor.data

import android.content.Context
import android.net.Uri
import com.sashakhyzhun.healthmonitor.data.prefs.IPreferencesHelper

/**
 * @author SashaKhyzhun
 * Created on 8/28/18.
 */
class AppDataManager constructor(
            private val context: Context,
            //private val dbHelper: IDatabaseHelper,
            private val prefsHelper: IPreferencesHelper
    ) : IDataManagerHelper {

    override fun isRegisteredUser(): Boolean = prefsHelper.isRegisteredUser()

    override fun getPrefVersion(): Int = prefsHelper.getPrefVersion()


    /**
     * Preference actions
     */
    override fun createUserSession(name: String, email: String, phone: String, photo: Uri) {
        prefsHelper.createUserSession(name, email, phone, photo)
    }

    override fun setPreferName(i: Int) {
        prefsHelper.setPreferName(i)
    }

    override fun setIsRegisteredUser(value: Boolean) {
        prefsHelper.setIsRegisteredUser(value)
    }

    override fun setProfileImage(photo: Uri) {
        prefsHelper.setProfileImage(photo)
    }

    override fun getProfileImage(): Uri {
        return prefsHelper.getProfileImage()
    }

    override fun setUserName(name: String) {
        prefsHelper.setUserName(name)
    }

    override fun getUserName(): String {
        return prefsHelper.getUserName()
    }

    override fun setUserEmail(email: String) {
        prefsHelper.setUserEmail(email)
    }

    override fun getUserEmail(): String {
        return prefsHelper.getUserEmail()
    }

    override fun setPhoneNumber(phone: String) {
        prefsHelper.setPhoneNumber(phone)
    }

    override fun getPhoneNumber(): String {
        return prefsHelper.getPhoneNumber()
    }
}