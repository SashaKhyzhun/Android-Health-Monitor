package com.sashakhyzhun.healthmonitor.data.model


/**
 * Main Model
 */

sealed class Challenge()

data class ChallengeSelf(
        var title: String,
        var duration: Int,
        var doneForToday: Boolean,
        var lastCheckIn: Long = 0L
) : Challenge()

data class ChallengeDuel(
        var title: String,
        var duration: Int,
        var doneForToday: Boolean,
        var lastCheckIn: Long = 0L,
        var evemy: Friend? = null
) : Challenge()

data class ChallengeFit(
        var title: String,
        var duration: Int,
        var doneForToday: Boolean,
        var lastCheckIn: Long = 0L
) : Challenge()

enum class ChallengeType(type: String) {
    SELF("self"),
    DUEL("duel"),
    FIT("fit")
}
enum class ChallengeStatus(status: String) {
    FINISHED("finished"),
    INPROGRESS("inprogess"),
    EXAMPLE("example")
}