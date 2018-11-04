package com.sashakhyzhun.healthmonitor.data

import android.content.Context
import android.net.Uri
import com.sashakhyzhun.healthmonitor.data.db.IDatabaseHelper
import com.sashakhyzhun.healthmonitor.data.prefs.IPreferencesHelper
import com.sashakhyzhun.healthmonitor.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author SashaKhyzhun
 * Created on 8/28/18.
 */
@Singleton
class AppDataManager
@Inject constructor(
        @ApplicationContext private val context: Context,
        private val dbHelper: IDatabaseHelper,
        private val prefsHelper: IPreferencesHelper
) : IDataManagerHelper {

    override fun isNewUser(): Boolean = prefsHelper.isNewUser()

    override fun getPrefVersion(): Int = prefsHelper.getPrefVersion()


    override fun doSomething() {
    }

    /**
     * Preference actions
     */
    override fun createUserSession(name: String, email: String, phone: String, photo: Uri) {
        prefsHelper.createUserSession(name, email, phone, photo)
    }

    override fun setPreferName(i: Int) {
        prefsHelper.setPreferName(i)
    }

    override fun setIsNewUser(value: Boolean) {
        prefsHelper.setIsNewUser(value)
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

    override fun setWidth(n: Int) {
        prefsHelper.setWidth(n)
    }

    override fun getWidth(): Int {
        return prefsHelper.getWidth()
    }

    override fun setHeight(n: Int) {
        prefsHelper.setHeight(n)
    }

    override fun getHeight(): Int {
        return prefsHelper.getHeight()
    }

    override fun setBirthday(n: Long) {
        prefsHelper.setBirthday(n)
    }

    override fun getBirthday(): Long {
        return prefsHelper.getBirthday()
    }

    override fun setGender(gender: String) {
        prefsHelper.setGender(gender)
    }

    override fun getGender(): String {
        return prefsHelper.getGender()
    }


}