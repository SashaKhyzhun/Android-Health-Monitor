package com.sashakhyzhun.healthmonitor.data.db

import com.sashakhyzhun.healthmonitor.data.model.ChallengeEntity
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus

interface PaperDao {

    fun <T : ChallengeEntity> storeChallenge(status: ChallengeStatus, data: T)

    fun <T : ChallengeEntity> retrieveAllChallenges(status: ChallengeStatus): T?

    fun <T : ChallengeEntity> deleteOneChallenge(status: ChallengeStatus, data: T)

    fun <T : ChallengeEntity> deleteAllChallenges(status: ChallengeStatus)


}