package com.luismunyoz.rylaisscepter.ui.screens.main

import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.domain.interactor.GetChampionsInteractor
import com.luismunyoz.rylaisscepter.domain.interactor.UpdateChampionInteractor
import com.luismunyoz.rylaisscepter.domain.interactor.base.Bus
import com.luismunyoz.rylaisscepter.domain.interactor.base.InteractorExecutor
import com.luismunyoz.rylaisscepter.domain.interactor.event.ChampionsEvent
import com.luismunyoz.rylaisscepter.ui.entity.UIChampion
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper

/**
 * Created by llco on 11/09/2017.
 */
class MainPresenter(val view: MainContract.View,
                    override val bus: Bus,
                    val getChampionsInteractor: GetChampionsInteractor,
                    val storeChampionInteractor: UpdateChampionInteractor,
                    val interactorExecutor: InteractorExecutor,
                    val uiChampionDataMapper: UIChampionDataMapper) : MainContract.Presenter {

    lateinit var champions: List<Champion>

    fun start() {
        downloadChampions()
    }

    fun downloadChampions() {
        interactorExecutor.execute(getChampionsInteractor)
    }

    fun onEvent(event: ChampionsEvent) {
        this.champions = event.champions
        view.populateItems(uiChampionDataMapper.transform(champions))
    }

    override fun onChampionPressed(championId: String) {
        val champion = champions.first { it.id.equals(championId) }
        view.goToChampionDetails(uiChampionDataMapper.transform(champion))
    }

    override fun updateChampion(uiChampion: UIChampion) {
        val champion = champions.first { it.id.equals(uiChampion.id) }
        champion.primaryColor = uiChampion.primaryColor
        champion.primaryTextColor = uiChampion.primaryTextColor
        champion.primaryTitleColor = uiChampion.primaryTitleColor
        champion.lightColor = uiChampion.lightColor
        champion.darkColor = uiChampion.darkColor
        storeChampionInteractor.champion = champion
        interactorExecutor.execute(storeChampionInteractor)
    }

}