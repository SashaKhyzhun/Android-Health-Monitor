package com.sashakhyzhun.healthmonitor.ui.analytics

import com.sashakhyzhun.healthmonitor.data.IDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import javax.inject.Inject

class AnalyticsPresenterImpl<V : AnalyticsView> @Inject constructor(
        mDataManager: IDataManagerHelper
) : BasePresenter<V>(mDataManager), AnalyticsPresenter<V> {

    // ...

}