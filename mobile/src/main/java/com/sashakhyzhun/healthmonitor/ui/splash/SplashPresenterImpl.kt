package com.sashakhyzhun.healthmonitor.ui.splash

import android.os.Handler
import com.sashakhyzhun.healthmonitor.data.AppDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import javax.inject.Inject

class SplashPresenterImpl<V : SplashView> @Inject constructor(
        mDataManager: AppDataManagerHelper
) : BasePresenter<V>(mDataManager), SplashPresenter<V> {

    override fun redirectUserToNeededPage() {
        Handler().postDelayed({
            mMvpView?.apply {
                if (mDataManager.isNewUser()) {
                    startLoginActivity()
                } else {
                    startMainActivity()
                }
            }

        }, 1000)
    }
}