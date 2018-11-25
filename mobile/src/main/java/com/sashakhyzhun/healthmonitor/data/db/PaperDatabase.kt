package com.sashakhyzhun.healthmonitor.data.db

import android.annotation.SuppressLint
import com.sashakhyzhun.healthmonitor.data.model.ChallengeEntity
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus
import io.paperdb.Paper
import java.text.SimpleDateFormat
import java.util.*

/**
 * HealthMonitor/
 *              Challenges/
 *                      Finished/
 *                            ChallengeType
 *                      InProgress/
 *                            ChallengeType
 *                      Example/
 *                            ChallengeType
 *
 *              Friends/
 *                      Kris
 *                      Jessica
 *                      Andrew
 *
 *              UserInfo/
 *                      Height
 *                      Weight
 *                      Lifestyle
 *                      ...
 *
 */
object PaperDatabase : PaperDao {

    /**
     * storage to storage
     */
    private const val storage: String = "/storage/emulated/0"
    private const val app = "HealthMonitor"
    private const val path = "$storage/$app"

    private const val challenges = "Challenges"
    private const val friends = "Friends"

    /**
     * journey id
     */
    @SuppressLint("SimpleDateFormat")
    var today: String = SimpleDateFormat("yyyy/MM/dd").format(Date().time)

    override fun <T : ChallengeEntity> storeChallenge(status: ChallengeStatus, data: T) {
        Paper.bookOn(path, challenges).write(status.name, data)
    }

    override fun <T : ChallengeEntity> retrieveAllChallenges(status: ChallengeStatus): T? {
        return Paper.bookOn(path, challenges).read(status.name, null)
    }

    override fun <T : ChallengeEntity> deleteOneChallenge(status: ChallengeStatus, data: T) {
    }

    override fun <T : ChallengeEntity> deleteAllChallenges(status: ChallengeStatus) {
        Paper.bookOn(path, challenges).delete(status.name)
    }


//    /**
//     * STORE FUNCTION
//     */
//
//    override fun <T> storeWithPrefixAndTime(clazz: Class<T>, data: Any, prefix: String, time: Long) {
//        Paper.bookOn(
//                "$storage/$app/",
//                "$subFolder/${clazz.simpleName}")
//                .write("${clazz.simpleName}-$prefix-$chunk-$time", data)
//    }
//
//    /**
//     * RETRIEVE FUNCTIONS
//     */
//    override fun <T> retrieveWithTime(clazz: Class<T>, now: Long): T {
//        return Paper.bookOn(
//                "$storage/$app",
//                "$subFolder/${clazz.simpleName}")
//                .read("${clazz.simpleName}-$chunk-$now")
//    }
//
//    override fun <T> retrieveWithPrefix(clazz: Class<T>, prefix: String): T {
//        return Paper.bookOn(
//                "$storage/$app",
//                "$subFolder/${clazz.simpleName}")
//                .read("${clazz.simpleName}-$prefix")
//    }

}