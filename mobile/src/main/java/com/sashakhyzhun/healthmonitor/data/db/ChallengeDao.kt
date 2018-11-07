package com.sashakhyzhun.healthmonitor.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import java.util.ArrayList

@Dao
interface ChallengeDao {

    /**
     * default SQL behavior is ABORT
     */

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertOne(challenge: Challenge)

    @Query("DELETE FROM challenge_table WHERE title = :title")
    fun deleteOne(title: String)

    //@Query("SELECT * FROM challenge_table WHERE title = :title")
    //fun getOne(title: String)

    @Query("DELETE FROM challenge_table")
    fun deleteAll()

    @Query("SELECT * FROM challenge_table ORDER BY title ASC")
    fun getAll(): LiveData<List<Challenge>>


}