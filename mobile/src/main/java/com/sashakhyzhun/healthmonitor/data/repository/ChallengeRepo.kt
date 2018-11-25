package com.sashakhyzhun.healthmonitor.data.repository

import com.sashakhyzhun.healthmonitor.data.db.ChallengeDao
import com.sashakhyzhun.healthmonitor.data.db.ChallengeDatabase
import com.sashakhyzhun.healthmonitor.data.model.ChallengeSelf
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus.*
import io.paperdb.Paper

class ChallengeRepo : ChallengeDao {

    companion object {
        private const val challenges = "Challenges"
    }

    override fun storeSelf(data: MutableList<ChallengeSelf>) {
        Paper.book().write(INPROGRESS.name, data)
    }

    override fun getAllSelf(status: ChallengeStatus): MutableList<ChallengeSelf> {
        //val asd: List<Boolean> = Paper.book().read<String>("govno") as List<Boolean>
        return Paper.book()
                .read(status.name, mutableListOf<ChallengeSelf>()) as MutableList<ChallengeSelf>
    }

    override fun deleteOneSelf(status: ChallengeStatus, data: ChallengeSelf) {
        //ChallengeStatus.INPROGRESS.name
    }

    override fun deleteAllSelf(status: ChallengeStatus) {

    }

}