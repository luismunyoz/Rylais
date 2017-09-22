package com.luismunyoz.rylaisscepter.domain.interactor

import com.luismunyoz.rylaisscepter.domain.interactor.base.Event
import com.luismunyoz.rylaisscepter.domain.interactor.base.Interactor
import com.luismunyoz.rylaisscepter.domain.interactor.event.ChampionEvent
import com.luismunyoz.rylaisscepter.domain.interactor.event.ChampionsEvent
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository

/**
 * Created by llco on 11/09/2017.
 */
class GetChampionInteractor(val championsRepository: ChampionRepository) : Interactor {

    var id: String? = null

    override fun invoke(): Event {
        val id = this.id ?: throw IllegalStateException("id can´t be null")
        val champion = championsRepository.getChampion(id)
        return ChampionEvent(champion)
    }

}