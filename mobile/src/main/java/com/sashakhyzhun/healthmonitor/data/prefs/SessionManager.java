package com.sashakhyzhun.healthmonitor.data.prefs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


/**
 * @author SashaKhyzhun
 * Created on 15.10.2018
 */

public class SessionManager {


    private static final String PREFER_NAME = "health_monitor_pref";
    private static final String KEY_PREF_VERSION = "pref_version";

    private static final String KEY_USER_IS_LOGGED_IN = "KEY_USER_IS_LOGGED_IN";
    private static final String KEY_USER_NAME = "key_user_name";
    private static final String KEY_USER_PHONE = "key_user_phone";
    private static final String KEY_USER_EMAIL = "key_user_email";
    private static final String KEY_USER_PHOTO = "key_user_photo";
    private static final String KEY_USER_WEIGHT = "key_user_weight";
    private static final String KEY_USER_HEIGHT = "key_user_height";
    private static final String KEY_USER_BIRTHDAY = "key_user_birthday";
    private static final String KEY_USER_GENDER = "key_user_gender";

    private static final String KEY_USER_BLOOD = "key_user_blood";
    private static final String KEY_USER_ALLERGY = "key_user_allergy";
    private static final String KEY_USER_LIFESTYLE = "key_user_lifestyle";


    private static final int PRIVATE_MODE = 0;
    private static final int PREF_VERSION = 0;

    private static SessionManager instance = null;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    public SessionManager(Context context) {
        preferences = context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }


    public void createUserSession(@NotNull String name, @NotNull String email, @NotNull String phone, @Nullable Uri photo, int height, int weight, @NotNull String birthday) {
        editor.putBoolean(KEY_USER_IS_LOGGED_IN, true);
        editor.putInt(KEY_PREF_VERSION, 1);
        editor.putString(KEY_USER_NAME, name);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USER_PHONE, phone);
        editor.putString(KEY_USER_PHOTO, String.valueOf(photo));

        editor.putInt(KEY_USER_HEIGHT, height);
        editor.putInt(KEY_USER_WEIGHT, weight);
        editor.putString(KEY_USER_BIRTHDAY, birthday);
        editor.apply();
        editor.commit();
    }


    public void clearUserSession() {
        editor.clear();
        editor.apply();
        editor.commit();
    }

    public void setLoggedInStatus(boolean value) {
        editor.putBoolean(KEY_USER_IS_LOGGED_IN, value);
        editor.apply();
        editor.commit();
    }

    public Boolean isLoggedIn() {
        return preferences.getBoolean(KEY_USER_IS_LOGGED_IN, false);
    }


    public void setProfileImage(@NotNull Uri photo) {
        editor.putString(KEY_USER_PHOTO, String.valueOf(photo));
        editor.apply();
        editor.commit();
    }

    @NotNull
    public Uri getProfileImage() {
        return Uri.parse(preferences.getString(KEY_USER_PHOTO, ""));
    }


    public void setUserName(@NotNull String name) {
        editor.putString(KEY_USER_NAME, name);
        editor.apply();
        editor.commit();
    }

    @NotNull
    public String getUserName() {
        return preferences.getString(KEY_USER_NAME, "");

    }


    public void setUserEmail(@NotNull String email) {
        editor.putString(KEY_USER_EMAIL, email);
        editor.apply();
        editor.commit();
    }

    @NotNull
    public String getUserEmail() {
        return preferences.getString(KEY_USER_EMAIL, "");
    }


    public void setPhoneNumber(@NotNull String phone) {
        editor.putString(KEY_USER_PHONE, phone);
        editor.apply();
        editor.commit();
    }

    @NotNull
    public String getPhoneNumber() {
        return preferences.getString(KEY_USER_PHONE, "");
    }


    public void setWidth(int n) {
        editor.putInt(KEY_USER_WEIGHT, n);
        editor.apply();
        editor.commit();
    }

    public int getWidth() {
        return preferences.getInt(KEY_USER_WEIGHT, 0);
    }


    public void setHeight(int n) {
        editor.putInt(KEY_USER_HEIGHT, n);
        editor.apply();
        editor.commit();
    }

    public int getHeight() {
        return preferences.getInt(KEY_USER_HEIGHT, 0);
    }


    public void setBirthday(String n) {
        editor.putString(KEY_USER_BIRTHDAY, n);
        editor.apply();
        editor.commit();
    }

    public String getBirthday() {
        return preferences.getString(KEY_USER_BIRTHDAY, "18 August 1996");

    }

    public void setGender(@NotNull String gender) {
        editor.putString(KEY_USER_GENDER, gender);
        editor.apply();
        editor.commit();
    }

    @NotNull
    public String getGender() {
        return preferences.getString(KEY_USER_GENDER, "Male");
    }


    public void setPreferName(int i) {
        editor.putInt(KEY_PREF_VERSION, i);
        editor.apply();
        editor.commit();
    }

    public int getPrefVersion() {
        return preferences.getInt(KEY_PREF_VERSION, 0);
    }

    public void setBlood(String blood) {
        editor.putString(KEY_USER_BLOOD, blood);
        editor.apply();
        editor.commit();
    }

    @NotNull
    public String getBlood() {
        return preferences.getString(KEY_USER_BLOOD, "-2");
    }

    public void setAllergy(String allergy) {
        editor.putString(KEY_USER_ALLERGY, allergy);
        editor.apply();
        editor.commit();
    }

    @NotNull
    public String getAllergy() {
        return preferences.getString(KEY_USER_ALLERGY, "Lactose intolerance");
    }

    public void setLifestyle(String lifestyle) {
        editor.putString(KEY_USER_LIFESTYLE, lifestyle);
        editor.apply();
        editor.commit();
    }

    @Nullable
    public String getLifestyle() {
        return preferences.getString(KEY_USER_LIFESTYLE, "Normal");
    }


}