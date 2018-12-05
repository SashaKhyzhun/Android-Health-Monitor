package com.sashakhyzhun.healthmonitor.data.prefs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import com.sashakhyzhun.healthmonitor.ui.tutorial.TutorialActivity;

import java.util.HashMap;

public class WearSessionManager {

    private static final String KEY_TEXT_COLOR = "textColor";       // selected theme in settings
    private static final String KEY_BG_COLOR = "bgColor";           // selected theme in settings

    private static final String PREFER_NAME = "PreferName";         // Shared pref file name
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";   // All Shared Preferences Keys
    private static final String PREFER_VESION = "PreferVersion";    // Version of Shared Prefs.
    private static WearSessionManager instance = null;

    private int PRIVATE_MODE = 0;                                   // Shared pref mode
    private SharedPreferences pref;                                 // Shared Preferences reference
    private SharedPreferences.Editor editor;                        // Editor reference for SP
    private Context context;                                        // Context

    /**
     * Standard constructor to access this manager
     * @param context - simple context from class when we had created session manager.
     */
    @SuppressLint("CommitPrefEdits")
    private WearSessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public static WearSessionManager getInstance(Context context) {
        if (instance == null) {
            instance = new WearSessionManager(context);
        }
        return instance;
    }

    public void createUserLoginSession(int bgColor, int textColor) {
        editor.putBoolean(IS_USER_LOGIN, true); // Storing login value as TRUE
        editor.putInt(KEY_BG_COLOR, bgColor);
        editor.putInt(KEY_TEXT_COLOR, textColor);
        editor.putInt(PREFER_VESION, 1);
        editor.commit();
    }

    public void setPreferVesion(int i) {
        editor.putInt(PREFER_VESION, i);
    }

    public HashMap<String, Integer> getUserTheme() {
        HashMap<String, Integer> user = new HashMap<>();

        user.put(KEY_BG_COLOR,   pref.getInt(KEY_BG_COLOR, Color.BLACK));
        user.put(KEY_TEXT_COLOR, pref.getInt(KEY_TEXT_COLOR, Color.WHITE));

        return user;
    }


    public void setUserBackgroundColor(Integer backgroundColor) {
        editor.putInt(KEY_BG_COLOR, backgroundColor);
        editor.commit();
    }

    public void setUserTextColor(Integer textColor) {
        editor.putInt(KEY_TEXT_COLOR, textColor);
        editor.commit();
    }


    public int getPreferVersion() {
        return pref.getInt(PREFER_VESION, 0);
    }

    public int getUserBackgroundColor() {
        return pref.getInt("bgColor", Color.BLACK);
    }

    public int getUserTextColor() {
        return pref.getInt("textColor", Color.WHITE);
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_USER_LOGIN, false);
    }



    public boolean checkLogin() {
        // Check login status
        if (!this.isLoggedIn()) {
            Intent i = new Intent(context, TutorialActivity.class); // because is not logged-in
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Closing all the Activities from stack
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // Add new Flag to start new Activity
            context.startActivity(i);
            return true;
        }
        return false;
    }

    public void logoutUser() {
        editor.clear();  // Clearing all user data from Shared Preferences
        editor.commit();

        Intent i = new Intent(context, TutorialActivity.class); // After logout redirect
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);            // Closing all the Activities
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);             // Add new Flag to start new Activity
        context.startActivity(i);                              // Staring Login Activity
    }

}
