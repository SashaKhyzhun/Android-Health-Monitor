package com.sashakhyzhun.healthmonitor.ui.analytics

import com.sashakhyzhun.healthmonitor.data.AppDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import javax.inject.Inject

class AnalyticsPresenterImpl<V : AnalyticsView> @Inject constructor(
        mDataManager: AppDataManagerHelper
) : BasePresenter<V>(mDataManager), AnalyticsPresenter<V> {

    // ...

}