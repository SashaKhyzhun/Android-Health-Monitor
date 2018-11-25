package com.sashakhyzhun.healthmonitor.data.db

import com.sashakhyzhun.healthmonitor.data.model.ChallengeSelf
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus

interface ChallengeDao {

    fun storeSelf(data: MutableList<ChallengeSelf>)
    fun getAllSelf(status: ChallengeStatus): MutableList<ChallengeSelf>
    fun deleteOneSelf(status: ChallengeStatus, data: ChallengeSelf)
    fun deleteAllSelf(status: ChallengeStatus)


}