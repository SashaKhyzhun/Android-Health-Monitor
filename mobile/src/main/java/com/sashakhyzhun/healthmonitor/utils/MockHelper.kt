package com.sashakhyzhun.healthmonitor.utils

import com.sashakhyzhun.healthmonitor.data.model.Challenge



fun MutableList<Challenge>.fillWithMockChallenges() {
    this.add(Challenge("Don't smoke", 21, "type_qwerty", null))
    this.add(Challenge("Sugar free life", 7, "type_qwerty", "Andrew"))
    this.add(Challenge("Morning exercise", 11, "type_qwerty", null))
    this.add(Challenge("No TV", 14, "type_qwerty", null))
    this.add(Challenge("Reading books", 19, "type_qwerty", null))
}


fun loadDefaultChallenges(): List<Challenge> {
    return listOf(
            Challenge("Smoking free live", 21, "type_qwerty", null, 0L, false),
            Challenge("No TV", 21, "type_qwerty", null, 0L, false),
            Challenge("Taking stairs", 21, "type_qwerty", null, 0L, false),
            Challenge("Sugar free live", 21, "type_qwerty", null, 0L, false),
            Challenge("10K steps per day", 21, "type_qwerty", null, 0L, false),
            Challenge("Drink more water", 21, "type_qwerty", null, 0L, false),
            Challenge("Sleep before midnight", 21, "type_qwerty", null, 0L, false)
    )
}
