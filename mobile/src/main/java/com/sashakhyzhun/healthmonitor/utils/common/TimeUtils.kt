package com.sashakhyzhun.healthmonitor.utils.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * @author SashaKhyzhun
 * Created on 5/30/17.
 */

object TimeUtils {

    /**
     * Local utils
     */
    fun now(): String {
        val sdf = SimpleDateFormat("MMM dd, hh:mm", Locale.getDefault())
        val date = Date()
        return sdf.format(date)
    }

}
