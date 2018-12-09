package com.sashakhyzhun.healthmonitor.data.model

import com.sashakhyzhun.healthmonitor.R


/**
 * Main Model
 */

//sealed class Challenge

data class Challenge(
        var title: String,
        var currentDay: Int = 1,
        var duration: Int = 21,
        var doneForToday: Boolean = false,
        var lastCheckIn: Long = 0L,
        var enemy: String = "",
        var type: ChallengeType,
        var status: ChallengeStatus,
        var image: Int = R.drawable.ic_sword
)
