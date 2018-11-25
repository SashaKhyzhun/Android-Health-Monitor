package com.sashakhyzhun.healthmonitor.data.db

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 * HealthMonitor/
 *              Challenges/
 *                      Finished/
 *                            ChallengeType
 *                      InProgress/
 *                            ChallengeType
 *                      Example/
 *                            ChallengeType
 *
 *              Friends/
 *                      Kris
 *                      Jessica
 *                      Andrew
 *
 *              UserInfo/
 *                      Height
 *                      Weight
 *                      Lifestyle
 *                      ...
 *
 */
object ChallengeDatabase {

    const val storage: String = "/storage/emulated/0"
    const val app = "HealthMonitor"
    const val path = "$storage/$app"


    @SuppressLint("SimpleDateFormat")
    var today: String = SimpleDateFormat("yyyy/MM/dd").format(Date().time)

}