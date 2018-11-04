package com.sashakhyzhun.healthmonitor.di.module

import android.content.Context
import android.support.v4.content.res.TypedArrayUtils.getString
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.di.ActivityContext
import com.sashakhyzhun.healthmonitor.di.PerActivity
import com.sashakhyzhun.healthmonitor.ui.login.LoginPresenter
import com.sashakhyzhun.healthmonitor.ui.login.LoginPresenterImpl
import com.sashakhyzhun.healthmonitor.ui.login.LoginView
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


}