package com.sashakhyzhun.healthmonitor.utils

import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus
import com.sashakhyzhun.healthmonitor.data.model.ChallengeType

/**
 * DEFAULT
 */

fun fillSelfChallenges(): List<Challenge> {
    return listOf(
            Challenge("Drink more water", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE, R.drawable.ic_drink_more_water),
            Challenge("Taking stairs", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE, R.drawable.ic_stairs),
            Challenge("Sugar free life", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE, R.drawable.ic_food),
            Challenge("No smoking", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE, R.drawable.ic_no_smoking),
            Challenge("Reading books", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE, R.drawable.ic_books),
            Challenge("No TV", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE, R.drawable.ic_no_tv),
            Challenge("Meditation", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE, R.drawable.ic_flower),
            Challenge("No alcohol", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE, R.drawable.ic_no_alcohol),
            Challenge("Getting rid of bad thinking", 21,false, 0L, "", ChallengeType.SELF, ChallengeStatus.EXAMPLE, R.drawable.ic_bad_thinking)
    )
}

fun fillDuelChallenges(): List<Challenge> {
    return listOf(
            Challenge("No video games", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE, R.drawable.ic_playstation),
            Challenge("Sharing your items", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE),
            Challenge("Doing morning exercise", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE, R.drawable.ic_golf),
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
