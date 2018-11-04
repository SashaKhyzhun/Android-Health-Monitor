package com.sashakhyzhun.healthmonitor.data.prefs

import android.net.Uri


interface IPreferencesHelper {

    fun createUserSession(name: String, email: String, phone: String, photo: Uri)


    fun setIsNewUser(value: Boolean)
    fun isNewUser(): Boolean


    fun setProfileImage(photo: Uri)
    fun getProfileImage(): Uri


    fun setUserName(name: String)
    fun getUserName(): String


    fun setUserEmail(email: String)
    fun getUserEmail(): String


    fun setPhoneNumber(phone: String)
    fun getPhoneNumber(): String

    fun setWidth(n: Int)
    fun getWidth(): Int


    fun setHeight(n: Int)
    fun getHeight(): Int


    fun setBirthday(n: Long)
    fun getBirthday(): Long


    fun setGender(gender: String)
    fun getGender(): String




    // Another
    fun getPrefVersion(): Int
    fun setPreferName(i: Int)

}
