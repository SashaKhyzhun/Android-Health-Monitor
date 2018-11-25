package com.sashakhyzhun.healthmonitor.ui.profile

import com.sashakhyzhun.healthmonitor.data.AppDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import javax.inject.Inject

class ProfilePresenterImpl<V : ProfileView> @Inject constructor(
        mDataManager: AppDataManagerHelper
) : BasePresenter<V>(mDataManager), ProfilePresenter<V> {


}