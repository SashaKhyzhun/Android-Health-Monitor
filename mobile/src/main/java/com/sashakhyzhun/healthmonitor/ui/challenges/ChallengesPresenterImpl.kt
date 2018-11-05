package com.sashakhyzhun.healthmonitor.ui.challenges

import com.sashakhyzhun.healthmonitor.data.IDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import javax.inject.Inject

class ChallengesPresenterImpl<V : ChallengesView> @Inject constructor(
        mDataManager: IDataManagerHelper
) : BasePresenter<V>(mDataManager), ChallengesPresenter<V> {



}