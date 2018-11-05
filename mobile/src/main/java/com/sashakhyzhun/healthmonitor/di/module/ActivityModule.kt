package com.sashakhyzhun.healthmonitor.di.module

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.content.res.TypedArrayUtils.getString
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.di.ActivityContext
import com.sashakhyzhun.healthmonitor.di.PerActivity
import com.sashakhyzhun.healthmonitor.ui.analytics.AnalyticsPresenter
import com.sashakhyzhun.healthmonitor.ui.analytics.AnalyticsPresenterImpl
import com.sashakhyzhun.healthmonitor.ui.analytics.AnalyticsView
import com.sashakhyzhun.healthmonitor.ui.challenges.ChallengesPresenter
import com.sashakhyzhun.healthmonitor.ui.challenges.ChallengesPresenterImpl
import com.sashakhyzhun.healthmonitor.ui.challenges.ChallengesView
import com.sashakhyzhun.healthmonitor.ui.challenges.create.CreatePresenter
import com.sashakhyzhun.healthmonitor.ui.challenges.create.CreatePresenterImpl
import com.sashakhyzhun.healthmonitor.ui.challenges.create.CreateView
import com.sashakhyzhun.healthmonitor.ui.healthrate.HeartRatePresenter
import com.sashakhyzhun.healthmonitor.ui.healthrate.HeartRatePresenterImpl
import com.sashakhyzhun.healthmonitor.ui.healthrate.HeartRateView
import com.sashakhyzhun.healthmonitor.ui.login.LoginPresenter
import com.sashakhyzhun.healthmonitor.ui.login.LoginPresenterImpl
import com.sashakhyzhun.healthmonitor.ui.login.LoginView
import com.sashakhyzhun.healthmonitor.ui.profile.ProfilePresenter
import com.sashakhyzhun.healthmonitor.ui.profile.ProfilePresenterImpl
import com.sashakhyzhun.healthmonitor.ui.profile.ProfileView
import com.sashakhyzhun.healthmonitor.ui.settings.SettingsPresenter
import com.sashakhyzhun.healthmonitor.ui.settings.SettingsPresenterImpl
import com.sashakhyzhun.healthmonitor.ui.settings.SettingsView
import com.sashakhyzhun.healthmonitor.ui.splash.SplashPresenter
import com.sashakhyzhun.healthmonitor.ui.splash.SplashPresenterImpl
import com.sashakhyzhun.healthmonitor.ui.splash.SplashView
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor(val activity: AppCompatActivity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context = activity

    @Provides
    fun provideActivity(): AppCompatActivity = activity

    @Provides
    fun provideGoogleSignInOptions(): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(activity.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
    }

    @Provides
    fun provideLinearLayoutManager(activity: AppCompatActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }

    /**
     * Presenters
     */

    @Provides
    @PerActivity
    fun provideSplashPresenter(presenter: SplashPresenterImpl<SplashView>): SplashPresenter<SplashView> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideLoginPresenter(presenter: LoginPresenterImpl<LoginView>): LoginPresenter<LoginView> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideProfilePresenter(presenter: ProfilePresenterImpl<ProfileView>): ProfilePresenter<ProfileView> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideSettingsPresenter(presenter: SettingsPresenterImpl<SettingsView>): SettingsPresenter<SettingsView> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideHeartRatePresenter(presenter: HeartRatePresenterImpl<HeartRateView>): HeartRatePresenter<HeartRateView> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideChallengesPresenter(presenter: ChallengesPresenterImpl<ChallengesView>): ChallengesPresenter<ChallengesView> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideCreatePresenter(presenter: CreatePresenterImpl<CreateView>): CreatePresenter<CreateView> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideAnalyticsresenter(presenter: AnalyticsPresenterImpl<AnalyticsView>): AnalyticsPresenter<AnalyticsView> {
        return presenter
    }


}