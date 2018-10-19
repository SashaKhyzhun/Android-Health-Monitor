package com.sashakhyzhun.healthmonitor.data.model

data class Challenge(
        var title: String,
        var duration: Int,
        var type: ChallengeType,
        var enemy: String?
)

/*

    Need:

    1. last CheckIn time
    2. duration in days
    3. done for today bool
    4.

 */