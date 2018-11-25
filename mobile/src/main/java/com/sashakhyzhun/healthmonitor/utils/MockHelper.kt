package com.sashakhyzhun.healthmonitor.utils

import com.sashakhyzhun.healthmonitor.data.model.ChallengeDuel
import com.sashakhyzhun.healthmonitor.data.model.ChallengeFit
import com.sashakhyzhun.healthmonitor.data.model.ChallengeSelf
import com.sashakhyzhun.healthmonitor.data.model.ChallengeType


fun fillSelfChallenges(): List<ChallengeSelf> {
    return listOf(
            ChallengeSelf("self title 1", 21,false),
            ChallengeSelf("self title 2", 21,false),
            ChallengeSelf("self title 3", 21,false),
            ChallengeSelf("self title 4", 21,false),
            ChallengeSelf("self title 5", 21,false),
            ChallengeSelf("self title 6", 21,false),
            ChallengeSelf("self title 7", 21,false),
            ChallengeSelf("self title 8", 21,false),
            ChallengeSelf("self title 9", 21,false)
    )
}

fun fillDuelChallenges(): List<ChallengeDuel> {
    return listOf(
            ChallengeDuel("duel title 1", 21,false, 0),
            ChallengeDuel("duel title 2", 21,false, 0),
            ChallengeDuel("duel title 3", 21,false, 0),
            ChallengeDuel("duel title 4", 21,false, 0),
            ChallengeDuel("duel title 5", 21,false, 0),
            ChallengeDuel("duel title 6", 21,false, 0),
            ChallengeDuel("duel title 7", 21,false, 0),
            ChallengeDuel("duel title 8", 21,false, 0),
            ChallengeDuel("duel title 9", 21,false, 0)
    )
}


fun fillFitChallenges(): List<ChallengeFit> {
    return listOf(
            ChallengeFit("fit title 1", 21,false),
            ChallengeFit("fit title 2", 21,false),
            ChallengeFit("fit title 3", 21,false),
            ChallengeFit("fit title 4", 21,false),
            ChallengeFit("fit title 5", 21,false),
            ChallengeFit("fit title 6", 21,false),
            ChallengeFit("fit title 7", 21,false),
            ChallengeFit("fit title 8", 21,false),
            ChallengeFit("fit title 9", 21,false)
    )
}