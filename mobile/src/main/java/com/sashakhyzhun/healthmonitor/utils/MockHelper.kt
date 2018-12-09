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
            Challenge("Doing morning exercise", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE, R.drawable.ic_golf),
            Challenge("Watching out for animals", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE, R.drawable.ic_cat),
            Challenge("No smoking", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE, R.drawable.ic_no_smoking),
            Challenge("Doing homework", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE, R.drawable.ic_homework),
            Challenge("Sharing your items", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE, R.drawable.ic_share_food),
            Challenge("Getting rid of bad thinking", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE, R.drawable.ic_bad_thinking),
            Challenge("No alcohol", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE, R.drawable.ic_no_alcohol),
            Challenge("Meditation", 21,false, 0L, "", ChallengeType.DUEL, ChallengeStatus.EXAMPLE, R.drawable.ic_flower)
    )
}

fun fillFitChallenges(): List<Challenge> {
    return listOf(
            Challenge("Aerobics", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE, R.drawable.ic_aerobics),
            Challenge("Biking", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE, R.drawable.ic_bike),
            Challenge("Push ups", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE, R.drawable.ic_push_up),
            Challenge("Swimming", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE, R.drawable.ic_swim),
            Challenge("Walking", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE, R.drawable.ic_walk),
            Challenge("Running", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE, R.drawable.ic_run),
            Challenge("Gym", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE, R.drawable.ic_gym),
            Challenge("Jumping Jack", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE, R.drawable.ic_jump),
            Challenge("Dancing", 21,false, 0L, "", ChallengeType.FIT, ChallengeStatus.EXAMPLE, R.drawable.ic_dance)
    )
}
