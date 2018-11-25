package com.sashakhyzhun.healthmonitor.data.db

import com.sashakhyzhun.healthmonitor.data.model.*

interface ChallengeDao {

//    fun storeSelf(data: MutableList<Challenge>)
//    fun getAllSelf(status: ChallengeStatus): MutableList<Challenge>
//    fun deleteAllSelf(status: ChallengeStatus)
//
//    fun storeDuel(data: MutableList<ChallengeDuel>)
//    fun getAllDuel(status: ChallengeStatus): MutableList<ChallengeDuel>
//    fun deleteAllDuel(status: ChallengeStatus)
//
//    fun storeFit(data: MutableList<ChallengeFit>)
//    fun getAllFit(status: ChallengeStatus): MutableList<ChallengeFit>
//    fun deleteAllFit(status: ChallengeStatus)

//    fun <T : Challenge> getSelf(status: ChallengeStatus): MutableList<T>
//    fun <T : Challenge> saveSelf(data: MutableList<T>)
//
//    fun <T : Challenge> getDuel(status: ChallengeStatus): MutableList<T>
//    fun <T : Challenge> saveDue(data: MutableList<T>)
//
//    fun <T : Challenge> getFit(status: ChallengeStatus): MutableList<T>
//    fun <T : Challenge> getFit(data: MutableList<T>)

    fun getAllInProgress(): MutableList<Challenge>

    fun saveAllInProgress(data: MutableList<Challenge>)


}