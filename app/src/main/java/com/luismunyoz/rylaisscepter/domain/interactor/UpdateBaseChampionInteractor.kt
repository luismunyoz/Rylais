package com.luismunyoz.rylaisscepter.domain.interactor

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.interactor.base.Event
import com.luismunyoz.rylaisscepter.domain.interactor.base.Interactor
import com.luismunyoz.rylaisscepter.domain.interactor.event.BaseChampionEvent
import com.luismunyoz.rylaisscepter.domain.interactor.event.ChampionEvent
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository

/**
 * Created by llco on 11/09/2017.
 */
class UpdateBaseChampionInteractor(val championsRepository: ChampionRepository) : Interactor {

    var baseChampion: BaseChampion? = null

    override fun invoke(): Event {
        val champion = this.baseChampion ?: throw IllegalStateException("baseChampion can´t be null")
        championsRepository.storeBaseChampion(champion)
        return BaseChampionEvent(champion)
    }

}