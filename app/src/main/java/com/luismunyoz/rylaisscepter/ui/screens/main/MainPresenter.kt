package com.luismunyoz.rylaisscepter.ui.screens.main

import com.luismunyoz.rylaisscepter.domain.interactor.GetChampionsInteractor
import com.luismunyoz.rylaisscepter.domain.interactor.base.Bus
import com.luismunyoz.rylaisscepter.domain.interactor.base.InteractorExecutor
import com.luismunyoz.rylaisscepter.domain.interactor.event.ChampionsEvent
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper

/**
 * Created by llco on 11/09/2017.
 */
class MainPresenter(val view: MainContract.View,
                    override val bus: Bus,
                    val getChampionsInteractor: GetChampionsInteractor,
                    val interactorExecutor: InteractorExecutor,
                    val uiChampionDataMapper: UIChampionDataMapper) : MainContract.Presenter {

    fun start() {
        downloadChampions()
    }

    fun downloadChampions() {
        interactorExecutor.execute(getChampionsInteractor)
    }

    fun onEvent(event: ChampionsEvent) {
        view.populateItems(uiChampionDataMapper.transform(event.champions))
    }
}