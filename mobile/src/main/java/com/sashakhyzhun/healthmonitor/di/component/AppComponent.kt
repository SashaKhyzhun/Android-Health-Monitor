package com.sashakhyzhun.healthmonitor.di.component

import android.app.Application
import android.content.Context
import com.sashakhyzhun.healthmonitor.HealthMonitor
import com.sashakhyzhun.healthmonitor.data.AppDataManagerHelper
import com.sashakhyzhun.healthmonitor.di.ApplicationContext
import com.sashakhyzhun.healthmonitor.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: HealthMonitor)


    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): AppDataManagerHelper


}