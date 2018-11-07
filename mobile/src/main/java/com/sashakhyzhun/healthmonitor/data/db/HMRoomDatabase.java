package com.sashakhyzhun.healthmonitor.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.sashakhyzhun.healthmonitor.data.model.Challenge;

@Database(entities = {Challenge.class}, version = 1)
public abstract class HMRoomDatabase extends RoomDatabase {

    /**
     * @return Dao
     */
    public abstract ChallengeDao challengeDao();


    private static volatile HMRoomDatabase INSTANCE;


    public static HMRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (HMRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            HMRoomDatabase.class, "health_monitor_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}