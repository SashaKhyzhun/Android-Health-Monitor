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
            Challenge(title = "Drink more water", type = ChallengeType.SELF, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_drink_more_water),
            Challenge(title = "Taking stairs", type = ChallengeType.SELF, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_stairs),
            Challenge(title = "Sugar free life", type = ChallengeType.SELF, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_food),
            Challenge(title = "No smoking", type = ChallengeType.SELF, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_no_smoking),
            Challenge(title = "Reading books", type = ChallengeType.SELF, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_books),
            Challenge(title = "No TV", type = ChallengeType.SELF, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_no_tv),
            Challenge(title = "Meditation", type = ChallengeType.SELF, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_flower),
            Challenge(title = "No alcohol", type = ChallengeType.SELF, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_no_alcohol),
            Challenge(title = "Getting rid of bad thinking", type = ChallengeType.SELF, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_bad_thinking)
    )
}

fun fillDuelChallenges(): List<Challenge> {
    return listOf(
            Challenge(title = "No video games", type = ChallengeType.DUEL, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_playstation),
            Challenge(title = "Doing morning exercise", type = ChallengeType.DUEL, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_golf),
            Challenge(title = "Watching out for animals", type = ChallengeType.DUEL, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_cat),
            Challenge(title = "No smoking", type = ChallengeType.DUEL, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_no_smoking),
            Challenge(title = "Doing homework", type = ChallengeType.DUEL, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_homework),
            Challenge(title = "Sharing your items", type = ChallengeType.DUEL, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_share_food),
            Challenge(title = "Getting rid of bad thinking", type = ChallengeType.DUEL, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_bad_thinking),
            Challenge(title = "No alcohol", type = ChallengeType.DUEL, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_no_alcohol),
            Challenge(title = "Meditation", type = ChallengeType.DUEL, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_flower)
    )
}

fun fillFitChallenges(): List<Challenge> {
    return listOf(
            Challenge(title = "Aerobics", type = ChallengeType.FIT, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_aerobics),
            Challenge(title = "Biking", type = ChallengeType.FIT, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_bike),
            Challenge(title = "Push ups", type = ChallengeType.FIT, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_push_up),
            Challenge(title = "Swimming", type = ChallengeType.FIT, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_swim),
            Challenge(title = "Walking", type = ChallengeType.FIT, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_walk),
            Challenge(title = "Running", type = ChallengeType.FIT, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_run),
            Challenge(title = "Gym", type = ChallengeType.FIT, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_gym),
            Challenge(title = "Jumping Jack", type = ChallengeType.FIT, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_jump),
            Challenge(title = "Dancing", type = ChallengeType.FIT, status = ChallengeStatus.EXAMPLE, image = R.drawable.ic_dance)
    )
}
