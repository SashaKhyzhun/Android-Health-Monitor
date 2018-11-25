package com.sashakhyzhun.healthmonitor.data.repository

import com.sashakhyzhun.healthmonitor.data.db.ChallengeDao
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus.*
import io.paperdb.Paper

class ChallengeRepo : ChallengeDao {

    companion object {
        private const val challenges = "Challenges"
        private const val inprogress = "-inprogress"
        // return Paper.book().read(status.name, mutableListOf<Challenge>()) as MutableList<Challenge>
    }


    override fun getAllInProgress(): MutableList<Challenge> {
        return Paper.book().read("$challenges$inprogress", mutableListOf<Challenge>())
                as MutableList<Challenge>
    }

    override fun saveAllInProgress(data: MutableList<Challenge>) {
        Paper.book().write("$challenges$inprogress", data)
    }

}

