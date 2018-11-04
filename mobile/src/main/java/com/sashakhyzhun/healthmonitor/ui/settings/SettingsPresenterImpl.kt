package com.sashakhyzhun.healthmonitor.ui.settings

import com.sashakhyzhun.healthmonitor.data.IDataManagerHelper
import com.sashakhyzhun.healthmonitor.ui.base.BasePresenter
import com.sashakhyzhun.healthmonitor.ui.base.MvpPresenter
import javax.inject.Inject

class SettingsPresenterImpl<V : SettingsView> @Inject constructor(
        mDataManager: IDataManagerHelper
) : BasePresenter<V>(mDataManager), SettingsPresenter<V> {



}