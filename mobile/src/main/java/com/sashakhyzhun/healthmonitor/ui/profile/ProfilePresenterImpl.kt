package com.sashakhyzhun.healthmonitor.ui.profile

import com.sashakhyzhun.healthmonitor.data.IDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import javax.inject.Inject

class ProfilePresenterImpl<V : ProfileView> @Inject constructor(
        mDataManager: IDataManagerHelper
) : BasePresenter<V>(mDataManager), ProfilePresenter<V> {

    // ...

}