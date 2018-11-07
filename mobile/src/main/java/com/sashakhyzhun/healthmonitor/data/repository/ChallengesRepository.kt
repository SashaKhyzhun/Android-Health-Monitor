package com.sashakhyzhun.healthmonitor.data.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.sashakhyzhun.healthmonitor.data.db.ChallengeDao
import com.sashakhyzhun.healthmonitor.data.db.HMRoomDatabase
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author SashaKhyzhun
 * Created on 10/5/18.
 */
class ChallengesRepository constructor(app: Application) {

    private var dao: ChallengeDao
    private var all: LiveData<List<Challenge>>

    init {
        val db = HMRoomDatabase.getDatabase(app)
        dao = db?.challengeDao()!!
        all = dao.getAll()
    }


    fun getAll(): LiveData<List<Challenge>> = all


    fun insert(challenge: Challenge) {
        InsertAsyncTask(dao).execute(challenge)
    }


    private class InsertAsyncTask(val dao: ChallengeDao) : AsyncTask<Challenge, Void, Void>() {

        override fun doInBackground(vararg challenge: Challenge?): Void? {
            dao.insertOne(challenge[0]!!)
            return null
        }
    }

}
