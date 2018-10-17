package com.sashakhyzhun.healthmonitor.data.prefs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

/**
 * @author SashaKhyzhun
 *         Created on 9/4/17.
 */

public class PreferencesHelper implements IPreferencesHelper {


    private static final String PREFER_NAME = "health_monitor_pref";
    private static final String KEY_IS_NEW_USER = "new_user";
    private static final String KEY_PREF_VERSION = "pref_version";
    private static final String KEY_USER_NAME = "key_user_name";
    private static final String KEY_USER_EMAIL = "key_user_email";
    private static final String KEY_USER_PHONE = "key_user_phone";
    private static final String KEY_USER_PHOTO = "key_user_photo";
    private static final int PRIVATE_MODE = 0;
    private static final int PREF_VERSION = 0;

    private static PreferencesHelper instance = null;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    public PreferencesHelper(Context context) {
        preferences = context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }


    @Override
    public void createUserSession(@NonNull String name, @NonNull String email, @NonNull String phone, @NonNull Uri photo) {
        editor.putBoolean(KEY_IS_NEW_USER, false);
        editor.putInt(KEY_PREF_VERSION, 1);
        editor.putString(KEY_USER_NAME, name);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USER_PHONE, phone);
        editor.putString(KEY_USER_PHOTO, String.valueOf(photo));
        editor.apply();
        editor.commit();
    }

    @Override
    public void setIsRegisteredUser(boolean value) {
        editor.putBoolean(KEY_IS_NEW_USER, value);
        editor.apply();
        editor.commit();
    }

    @Override
    public boolean isRegisteredUser() {
        return preferences.getBoolean(KEY_IS_NEW_USER, false);
    }


    @Override
    public void setProfileImage(@NotNull Uri photo) {
        editor.putString(KEY_USER_PHOTO, String.valueOf(photo));
        editor.apply();
        editor.commit();
    }
    @NotNull
    @Override
    public Uri getProfileImage() {
        return Uri.parse(preferences.getString(KEY_USER_PHOTO, ""));
    }


    @Override
    public void setUserName(@NotNull String name) {
        editor.putString(KEY_USER_NAME, name);
        editor.apply();
        editor.commit();
    }
    @NotNull
    @Override
    public String getUserName() {
        return preferences.getString(KEY_USER_NAME, "");

    }


    @Override
    public void setUserEmail(@NotNull String email) {
        editor.putString(KEY_USER_EMAIL, email);
        editor.apply();
        editor.commit();
    }
    @NotNull
    @Override
    public String getUserEmail() {
        return preferences.getString(KEY_USER_EMAIL, "");
    }


    @Override
    public void setPhoneNumber(@NotNull String phone) {
        editor.putString(KEY_USER_PHONE, phone);
        editor.apply();
        editor.commit();
    }
    @NotNull
    @Override
    public String getPhoneNumber() {
        return preferences.getString(KEY_USER_PHONE, "");
    }




    @Override
    public void setPreferName(int i) {
        editor.putInt(KEY_PREF_VERSION, i);
        editor.apply();
        editor.commit();
    }

    @Override
    public int getPrefVersion() {
        return preferences.getInt(KEY_PREF_VERSION, 0);
    }

}