package com.sashakhyzhun.healthmonitor.data.db

import com.sashakhyzhun.healthmonitor.data.model.*

interface ChallengeDao {

    fun getAllInProgress(): MutableList<Challenge>

    fun saveAllInProgress(data: MutableList<Challenge>)


}