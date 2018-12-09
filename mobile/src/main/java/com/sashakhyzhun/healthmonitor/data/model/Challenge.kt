package com.sashakhyzhun.healthmonitor.data.model

import com.sashakhyzhun.healthmonitor.R


/**
 * Main Model
 */

//sealed class Challenge

data class Challenge(
        var title: String,
        var duration: Int,
        var doneForToday: Boolean,
        var lastCheckIn: Long = 0L,
        var enemy: String = "",
        var type: ChallengeType,
        var status: ChallengeStatus,
        var image: Int = R.drawable.ic_sword
)
