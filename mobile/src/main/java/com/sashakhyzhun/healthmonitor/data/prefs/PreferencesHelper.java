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
    private static final String KEY_PREF_VERSION = "pref_version";

    private static final String KEY_USER_IS_REGISTERED = "key_user_is_registered";
    private static final String KEY_USER_NAME = "key_user_name";
    private static final String KEY_USER_PHONE = "key_user_phone";
    private static final String KEY_USER_EMAIL = "key_user_email";
    private static final String KEY_USER_PHOTO = "key_user_photo";
    private static final String KEY_USER_WIDTH = "key_user_width";
    private static final String KEY_USER_HEIGHT = "key_user_height";
    private static final String KEY_USER_BIRTHDAY = "key_user_BIRTHDAY";
    private static final String KEY_USER_GENDER = "key_user_GENDER";

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
        editor.putBoolean(KEY_USER_IS_REGISTERED, true);
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
        editor.putBoolean(KEY_USER_IS_REGISTERED, value);
        editor.apply();
        editor.commit();
    }

    @Override
    public boolean isRegisteredUser() {
        return preferences.getBoolean(KEY_USER_IS_REGISTERED, false);
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
    public void setWidth(int n) {
        editor.putInt(KEY_USER_WIDTH, n);
        editor.apply();
        editor.commit();
    }
    @Override
    public int getWidth() {
        return preferences.getInt(KEY_USER_WIDTH, 0);
    }


    @Override
    public void setHeight(int n) {
        editor.putInt(KEY_USER_HEIGHT, n);
        editor.apply();
        editor.commit();
    }
    @Override
    public int getHeight() {
        return preferences.getInt(KEY_USER_HEIGHT, 0);

    }


    @Override
    public void setBirthday(long n) {
        editor.putLong(KEY_USER_BIRTHDAY, n);
        editor.apply();
        editor.commit();
    }
    @Override
    public long getBirthday() {
        return preferences.getLong(KEY_USER_BIRTHDAY, 0L);

    }


    @Override
    public void setGender(@NotNull String gender) {
        editor.putString(KEY_USER_GENDER, gender);
        editor.apply();
        editor.commit();
    }
    @NotNull
    @Override
    public String getGender() {
        return preferences.getString(KEY_USER_GENDER, "");
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