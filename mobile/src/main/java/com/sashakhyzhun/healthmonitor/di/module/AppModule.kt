package com.sashakhyzhun.healthmonitor.di.module

import android.app.Application
import android.content.Context
import com.sashakhyzhun.healthmonitor.data.AppDataManager
import com.sashakhyzhun.healthmonitor.data.AppDataManagerHelper
import com.sashakhyzhun.healthmonitor.data.prefs.IPreferencesHelper
import com.sashakhyzhun.healthmonitor.data.prefs.PreferencesHelper
import com.sashakhyzhun.healthmonitor.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val mApplication: Application) {


    @Provides
    @ApplicationContext
    @Singleton
    fun provideContext(): Context = mApplication

    @Provides
    @Singleton
    fun provideApplication(): Application = mApplication

    @Provides
    @Singleton
    fun provideIDataManagerHelper(appDataManager: AppDataManager): AppDataManagerHelper {
        return appDataManager
    }

//    @Provides
//    @Singleton
//    fun provideIDatabaseHelper(databaseManager: DatabaseHelper): ChallengeDao {
//        return databaseManager
//    }

    @Provides
    @Singleton
    fun providePreferencesManager(preferencesHelper: PreferencesHelper): IPreferencesHelper {
        return preferencesHelper
    }

}
