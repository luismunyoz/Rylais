package com.luismunyoz.rylaisscepter.ui.util

import com.luismunyoz.rylaisscepter.domain.interactor.base.Bus

/**
 * Created by llco on 11/09/2017.
 */
interface BaseContract {

    public interface BasePresenter {
        val bus: Bus

        fun onResume(){
            bus.register(this)
        }

        fun onPause(){
            bus.unregister(this)
        }
    }

    public interface BaseView<in T: BasePresenter>{

    }
}