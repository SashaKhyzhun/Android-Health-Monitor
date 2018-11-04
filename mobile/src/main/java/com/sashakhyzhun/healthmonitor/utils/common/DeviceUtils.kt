package com.sashakhyzhun.healthmonitor.utils.common

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings

public class DeviceUtils {

    @SuppressLint("all")
    fun getDeviceId(context: Context): String {
        return Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.ANDROID_ID
        )
    }

}