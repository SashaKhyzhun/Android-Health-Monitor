package com.sashakhyzhun.healthmonitor.ui.challenges

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.repository.ChallengesRepository

class ChallengesViewModel(app: Application) : AndroidViewModel(app) {

    private var mRepository: ChallengesRepository= ChallengesRepository(app)
    private var challenges: LiveData<List<Challenge>>

    init {
        challenges = mRepository.getAll()
    }

    fun getAllWords(): LiveData<List<Challenge>> = challenges

    fun insert(challenge: Challenge) {
        mRepository.insert(challenge)
    }


}