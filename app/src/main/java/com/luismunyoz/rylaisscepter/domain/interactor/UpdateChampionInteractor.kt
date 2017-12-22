package com.luismunyoz.rylaisscepter.domain.interactor

import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.domain.interactor.base.Event
import com.luismunyoz.rylaisscepter.domain.interactor.base.Interactor
import com.luismunyoz.rylaisscepter.domain.interactor.event.ChampionEvent
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository

/**
 * Created by llco on 11/09/2017.
 */
class UpdateChampionInteractor(val championsRepository: ChampionRepository) : Interactor {

    var champion: Champion? = null

    override fun invoke(): Event {
        val champion = this.champion ?: throw IllegalStateException("champion can´t be null")
        championsRepository.storeChampion(champion)
        return ChampionEvent(champion)
    }

}