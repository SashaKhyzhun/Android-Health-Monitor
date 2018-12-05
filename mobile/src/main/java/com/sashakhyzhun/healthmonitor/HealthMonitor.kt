package com.sashakhyzhun.healthmonitor

import android.app.Application
import com.sashakhyzhun.healthmonitor.utils.extension.ThreadAwareTree
import io.paperdb.Paper
import timber.log.Timber

class HealthMonitor : Application() {

    override fun onCreate() {
        super.onCreate()

        Paper.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(ThreadAwareTree)
        }
        Timber.d("called")
    }
}
