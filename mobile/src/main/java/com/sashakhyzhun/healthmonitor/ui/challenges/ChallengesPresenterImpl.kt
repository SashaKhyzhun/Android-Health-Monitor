package com.sashakhyzhun.healthmonitor.ui.challenges

import com.sashakhyzhun.healthmonitor.data.AppDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import javax.inject.Inject

class ChallengesPresenterImpl<V : ChallengesView> @Inject constructor(
        mDataManager: AppDataManagerHelper
) : BasePresenter<V>(mDataManager), ChallengesPresenter<V> {



}