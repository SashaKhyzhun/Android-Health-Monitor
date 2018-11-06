package com.sashakhyzhun.healthmonitor.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "challenge_table")
data class Challenge(
        @PrimaryKey @NonNull @ColumnInfo(name = "title") var title: String,
        var duration: Int,
        var type: ChallengeType,
        var enemy: String? = null,
        var lastCheckIn: Long = 0L,
        var doneForToday: Boolean = false
)

/*

    Need:

    1. last CheckIn time
    2. duration in days
    3. done for today bool
    4.

 */