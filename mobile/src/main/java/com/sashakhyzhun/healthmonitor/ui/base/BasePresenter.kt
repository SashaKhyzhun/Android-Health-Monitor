package com.sashakhyzhun.healthmonitor.ui.base

import com.sashakhyzhun.healthmonitor.data.AppDataManagerHelper

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
abstract class BasePresenter<V : MvpView>(
        val mDataManager: AppDataManagerHelper
) : MvpPresenter<V> {

    var mMvpView: V? = null


    override fun onAttach(mvpView: V) { mMvpView = mvpView }

    override fun onDetach() { mMvpView = null }

    fun checkViewAttached() { if (isViewAttached().not()) throw MvpViewNotAttachedException() }

    fun isViewAttached() = mMvpView != null

    //fun getMvpView(): V? = mMvpView

    //fun getDataManager(): IDataManagerHelper = mDataManager

    class MvpViewNotAttachedException : RuntimeException(
            "Please call Presenter.onAttach(MvpView) before"
                    + " requesting data to the Presenter"
    )

}