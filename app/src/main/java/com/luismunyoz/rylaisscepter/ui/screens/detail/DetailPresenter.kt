package com.luismunyoz.rylaisscepter.ui.screens.detail

import com.luismunyoz.rylaisscepter.domain.interactor.base.Bus
import com.luismunyoz.rylaisscepter.domain.interactor.base.InteractorExecutor
import com.luismunyoz.rylaisscepter.domain.interactor.event.ChampionEvent
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper

/**
 * Created by Luis on 12/09/2017.
 */
class DetailPresenter(val view: DetailContract.View,
                      override val bus: Bus,
                      val interactorExecutor: InteractorExecutor,
                      val uiChampionDataMapper: UIChampionDataMapper) : DetailContract.Presenter {

    fun start(id: Int) {

    }

    fun onEvent(event: ChampionEvent) {

    }

}