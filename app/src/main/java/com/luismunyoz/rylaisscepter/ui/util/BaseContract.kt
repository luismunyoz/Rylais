package com.luismunyoz.rylaisscepter.ui.util

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by llco on 11/09/2017.
 */
interface BaseContract {

    public interface BasePresenter {
        val disposable: CompositeDisposable

        fun onResume(){

        }

        fun onPause(){

        }

        fun onDestroy(){
            disposable.clear()
        }
    }

    public interface BaseView<in T: BasePresenter>{

    }
}