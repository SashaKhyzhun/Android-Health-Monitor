package com.sashakhyzhun.healthmonitor.ui.healthrate

import com.sashakhyzhun.healthmonitor.data.IDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import com.sashakhyzhun.healthmonitor.ui.base.MvpPresenter
import javax.inject.Inject

class HeartRatePresenterImpl<V : HeartRateView> @Inject constructor(
        mDataManager: IDataManagerHelper
) : BasePresenter<V>(mDataManager), HeartRatePresenter<V> {




}