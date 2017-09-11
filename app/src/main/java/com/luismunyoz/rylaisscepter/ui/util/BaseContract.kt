package com.luismunyoz.rylaisscepter.ui.util

/**
 * Created by llco on 11/09/2017.
 */
interface BaseContract {

    public interface BasePresenter {
        fun start()
    }

    public interface BaseView<in T: BasePresenter>{

        fun setPresenter(presenter: T)
    }
}