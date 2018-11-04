package com.sashakhyzhun.healthmonitor.di.component

import android.support.v4.app.Fragment
import com.sashakhyzhun.healthmonitor.di.PerActivity
import com.sashakhyzhun.healthmonitor.di.module.ActivityModule
import com.sashakhyzhun.healthmonitor.ui.healthrate.HeartRateFragment
import com.sashakhyzhun.healthmonitor.ui.login.LoginActivity
import com.sashakhyzhun.healthmonitor.ui.profile.ProfileFragment
import com.sashakhyzhun.healthmonitor.ui.settings.SettingsActivity
import com.sashakhyzhun.healthmonitor.ui.splash.SplashActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: SplashActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: SettingsActivity)


    fun inject(fragment: ProfileFragment)
    fun inject(fragment: HeartRateFragment)


}