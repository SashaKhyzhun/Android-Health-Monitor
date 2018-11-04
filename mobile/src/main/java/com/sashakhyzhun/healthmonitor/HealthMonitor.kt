package com.sashakhyzhun.healthmonitor

import android.app.Application
import com.sashakhyzhun.healthmonitor.data.AppDataManager
import com.sashakhyzhun.healthmonitor.di.component.AppComponent
import com.sashakhyzhun.healthmonitor.di.component.DaggerAppComponent
import com.sashakhyzhun.healthmonitor.di.module.AppModule
import com.sashakhyzhun.healthmonitor.utils.extension.ThreadAwareTree
import timber.log.Timber
import javax.inject.Inject

class HealthMonitor : Application() {

    @Inject
    lateinit var dataManager: AppDataManager

    lateinit var applicationComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        applicationComponent.inject(this)


        if (BuildConfig.DEBUG) {
            Timber.plant(ThreadAwareTree)
        }
        Timber.d("called")
    }

    fun getComponent(): AppComponent = applicationComponent

    fun setComponent(appComponent: AppComponent) {
        applicationComponent = appComponent
    }


}
