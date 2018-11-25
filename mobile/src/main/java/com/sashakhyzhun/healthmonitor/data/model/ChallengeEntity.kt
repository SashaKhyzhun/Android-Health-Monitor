package com.sashakhyzhun.healthmonitor.data.model

/**
 * General
 */
sealed class ChallengeEntity

/**
 * For Local types
 */
sealed class ChallengeType

/**
 * Main Model
 */
data class Challenge <T : ChallengeType> (
        var title: String,
        var duration: Int,
        var type: T,
        var doneForToday: Boolean,
        var lastCheckIn: Long = 0L
) : ChallengeEntity()

/**
 * Types
 */
data class ChallengeSelf(var useless: String) : ChallengeType()
data class ChallengeDuel(var enemy: Friend) : ChallengeType()
data class ChallengFitness(var hasWearable: Boolean) : ChallengeType()


enum class ChallengeStatus(status: String) {
    FINISHED("finished"),
    INPROGRESS("inprogess"),
    EXAMPLE("example")
}