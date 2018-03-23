package com.luismunyoz.rylaisscepter.ui.screens.detail

import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Luis on 12/09/2017.
 */
class DetailPresenter(val view: DetailContract.View,
                      val uiChampionDataMapper: UIChampionDataMapper) : DetailContract.Presenter {

    override val disposable: CompositeDisposable = CompositeDisposable()

    fun start(id: Int) {

    }

}