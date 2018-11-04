package com.sashakhyzhun.healthmonitor.di.component

import com.sashakhyzhun.healthmonitor.di.PerActivity
import com.sashakhyzhun.healthmonitor.di.module.ActivityModule
import com.sashakhyzhun.healthmonitor.ui.splash.SplashActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: SplashActivity)

}