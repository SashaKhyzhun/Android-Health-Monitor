package com.sashakhyzhun.healthmonitor.data.model

data class Challenge(
        var title: String,
        var duration: Int,
        var type: ChallengeType,
        var enemy: String? = null,
        var lastCheckIn: Long = 0L,
        var doneForToday: Boolean = false
)

/*

    Need:

    1. last CheckIn time
    2. duration in days
    3. done for today bool
    4.

 */