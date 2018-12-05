package com.sashakhyzhun.healthmonitor.utils

import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus
import com.sashakhyzhun.healthmonitor.data.model.ChallengeType

/**
 * DEFAULT
 */


//TODO: Update these texts from champy app.
//TODO: Update these images from champy app.

fun fillSelfChallenges(): List<Challenge> {
    return listOf(
            Challenge("self title 1", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("self title 2", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("self title 3", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("self title 4", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("self title 5", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("self title 6", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("self title 7", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("self title 8", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE),
            Challenge("self title 9", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE)
    )
}

fun fillDuelChallenges(): List<Challenge> {
    return listOf(
            Challenge("self title 1", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("self title 2", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("self title 3", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("self title 4", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("self title 5", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("self title 6", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("self title 7", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("self title 8", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("self title 9", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE)
    )
}

fun fillFitChallenges(): List<Challenge> {
    return listOf(
            Challenge("self title 1", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("self title 2", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("self title 3", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("self title 4", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("self title 5", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("self title 6", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("self title 7", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("self title 8", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE),
            Challenge("self title 9", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE)
    )
}
