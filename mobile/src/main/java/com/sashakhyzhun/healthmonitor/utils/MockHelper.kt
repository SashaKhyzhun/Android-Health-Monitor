package com.sashakhyzhun.healthmonitor.utils

import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.model.ChallengeSelf



fun MutableList<Challenge<ChallengeSelf>>.fillWithMockChallenges() {
    this.add(Challenge("Don't smoke", 21, ChallengeSelf(""), false, 0L))
    this.add(Challenge("Don't smoke", 21, ChallengeSelf(""), false, 0L))
    this.add(Challenge("Don't smoke", 21, ChallengeSelf(""), false, 0L))
    this.add(Challenge("Don't smoke", 21, ChallengeSelf(""), false, 0L))
    this.add(Challenge("Don't smoke", 21, ChallengeSelf(""), false, 0L))
    this.add(Challenge("Don't smoke", 21, ChallengeSelf(""), false, 0L))
    this.add(Challenge("Don't smoke", 21, ChallengeSelf(""), false, 0L))
}