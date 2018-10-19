package com.sashakhyzhun.healthmonitor.utils

import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.model.ChallengeType



fun MutableList<Challenge>.fillWithMockChallenges() {
    this.add(Challenge("Don't smoke", 21, ChallengeType.SELF, null))
    this.add(Challenge("Sugar free life", 7, ChallengeType.DUEL, "Andrew"))
    this.add(Challenge("Morning exercise", 11, ChallengeType.WAKEUP, null))
    this.add(Challenge("No TV", 14, ChallengeType.SELF, null))
    this.add(Challenge("Reading books", 19, ChallengeType.SELF, null))
}



