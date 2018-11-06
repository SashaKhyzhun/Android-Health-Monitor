package com.sashakhyzhun.healthmonitor.ui.settings

import com.sashakhyzhun.healthmonitor.data.AppDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import javax.inject.Inject

class SettingsPresenterImpl<V : SettingsView> @Inject constructor(
        mDataManager: AppDataManagerHelper
) : BasePresenter<V>(mDataManager), SettingsPresenter<V> {



}