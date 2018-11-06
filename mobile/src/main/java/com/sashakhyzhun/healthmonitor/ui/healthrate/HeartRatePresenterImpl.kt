package com.sashakhyzhun.healthmonitor.ui.healthrate

import com.sashakhyzhun.healthmonitor.data.AppDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import javax.inject.Inject

class HeartRatePresenterImpl<V : HeartRateView> @Inject constructor(
        mDataManager: AppDataManagerHelper
) : BasePresenter<V>(mDataManager), HeartRatePresenter<V> {




}