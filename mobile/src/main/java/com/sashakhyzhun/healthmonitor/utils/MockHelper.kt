package com.sashakhyzhun.healthmonitor.utils

import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus
import com.sashakhyzhun.healthmonitor.data.model.ChallengeType

/**
 * DEFAULT
 */

fun fillSelfChallenges(): List<Challenge> {
    return listOf(
            Challenge("Taking stairs", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("Sugar free life", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("Drink more water", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("No smoking", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("Reading books", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("No TV", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("Meditation", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("No alcohol", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("Getting rid of bad thinking", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE)
    )
}

fun fillDuelChallenges(): List<Challenge> {
    return listOf(
            Challenge("No video games", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("Sharing your items", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("Doing morning exercise", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("Watching out for animals", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("Getting rid of bad thinking", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("Doing homework", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("No smoking", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("No alcohol", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("Meditation", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE)
    )
}

fun fillFitChallenges(): List<Challenge> {
    return listOf(
            Challenge("Aerobics", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("Biking", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("Dancing", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("Running", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("Walking", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("Jumping Jack", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("Push ups", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("Gym", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("Skating", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE)
    )
}
