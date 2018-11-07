package com.sashakhyzhun.healthmonitor.ui.challenges.create

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.repository.ChallengesRepository

class CreateViewModel(app: Application) : AndroidViewModel(app) {

    private var mRepository: ChallengesRepository = ChallengesRepository(app)
    private var challenges: LiveData<List<Challenge>>

    init {
        challenges = mRepository.getAll()
    }

    fun create(challenge: Challenge) {
        mRepository.insert(challenge)
    }

}