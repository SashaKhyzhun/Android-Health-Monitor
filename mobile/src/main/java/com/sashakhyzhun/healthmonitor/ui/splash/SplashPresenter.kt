package com.sashakhyzhun.healthmonitor.ui.splash

import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import com.sashakhyzhun.healthmonitor.ui.base.MvpPresenter

interface SplashPresenter<T : SplashView> : MvpPresenter<T> {

    fun redirectUserToNeededPage()

}
