package com.sashakhyzhun.healthmonitor.ui.splash

import com.sashakhyzhun.healthmonitor.ui.base.MvpView

interface SplashView : MvpView {
    fun startMainActivity()
    fun startLoginActivity()
}
