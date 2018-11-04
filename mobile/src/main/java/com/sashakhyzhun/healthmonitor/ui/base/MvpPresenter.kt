package com.sashakhyzhun.healthmonitor.ui.base


interface MvpPresenter<V : MvpView> {

    fun onAttach(mvpView: V)

    fun onDetach()

}