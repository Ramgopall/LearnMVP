package com.duke.learnmvp.presenter

abstract class AbstractPresenter() : Presenter {
    protected var TAG = javaClass.simpleName


    override fun onStop() {
        //        mCompositeSubscription.clear();
    }

    override fun onStart() {

    }
}