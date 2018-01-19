package com.luismunyoz.rylaisscepter.ui.screens.main

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.entity.ChampionUIColors
import com.luismunyoz.rylaisscepter.domain.interactor.GetBaseChampionsInteractor
import com.luismunyoz.rylaisscepter.domain.interactor.UpdateBaseChampionInteractor
import com.luismunyoz.rylaisscepter.domain.interactor.base.Bus
import com.luismunyoz.rylaisscepter.domain.interactor.base.InteractorExecutor
import com.luismunyoz.rylaisscepter.domain.interactor.event.ChampionsEvent
import com.luismunyoz.rylaisscepter.ui.entity.UIBaseChampion
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper

/**
 * Created by llco on 11/09/2017.
 */
class MainPresenter(val view: MainContract.View,
                    override val bus: Bus,
                    val getBaseChampionsInteractor: GetBaseChampionsInteractor,
                    val storeBaseChampionInteractor: UpdateBaseChampionInteractor,
                    val interactorExecutor: InteractorExecutor,
                    val uiChampionDataMapper: UIChampionDataMapper) : MainContract.Presenter {

    lateinit var baseChampions: List<BaseChampion>

    fun start() {
        downloadChampions()
    }

    fun downloadChampions() {
        interactorExecutor.execute(getBaseChampionsInteractor)
    }

    fun onEvent(event: ChampionsEvent) {
        this.baseChampions = event.baseChampions
        view.populateItems(uiChampionDataMapper.transform(baseChampions))
    }

    override fun onChampionPressed(championId: String) {
        val champion = baseChampions.first { it.id.equals(championId) }
        view.goToChampionDetails(uiChampionDataMapper.transform(champion))
    }

    override fun updateChampion(uiBaseChampion: UIBaseChampion) {
        val champion = baseChampions.first { it.id.equals(uiBaseChampion.id) }
        uiBaseChampion.colors?.let {
            champion.colors = uiChampionDataMapper.transform(it)
            storeBaseChampionInteractor.baseChampion = champion
            interactorExecutor.execute(storeBaseChampionInteractor)
        }
    }

}