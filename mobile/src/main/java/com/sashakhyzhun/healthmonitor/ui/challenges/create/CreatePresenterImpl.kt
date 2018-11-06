package com.sashakhyzhun.healthmonitor.ui.challenges.create

import com.sashakhyzhun.healthmonitor.data.AppDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import javax.inject.Inject

class CreatePresenterImpl<V : CreateView> @Inject constructor(
        mDataManager: AppDataManagerHelper
): BasePresenter<V>(mDataManager), CreatePresenter<V> {




}