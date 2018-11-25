package com.sashakhyzhun.healthmonitor.data.model


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
        var status: ChallengeStatus
)
