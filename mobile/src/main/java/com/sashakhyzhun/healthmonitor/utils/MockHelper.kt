package com.sashakhyzhun.healthmonitor.utils

import com.sashakhyzhun.healthmonitor.data.model.Challenge



fun MutableList<Challenge>.fillWithMockChallenges() {
    this.add(Challenge("Don't smoke", 21, "type_qwerty", null))
    this.add(Challenge("Sugar free life", 7, "type_qwerty", "Andrew"))
    this.add(Challenge("Morning exercise", 11, "type_qwerty", null))
    this.add(Challenge("No TV", 14, "type_qwerty", null))
    this.add(Challenge("Reading books", 19, "type_qwerty", null))
}



