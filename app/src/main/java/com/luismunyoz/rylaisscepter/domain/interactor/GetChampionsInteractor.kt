package com.luismunyoz.rylaisscepter.domain.interactor

import com.luismunyoz.rylaisscepter.domain.interactor.base.Event
import com.luismunyoz.rylaisscepter.domain.interactor.base.Interactor
import com.luismunyoz.rylaisscepter.domain.interactor.event.ChampionsEvent
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository

/**
 * Created by llco on 11/09/2017.
 */
class GetChampionsInteractor(val championsRepository: ChampionRepository) : Interactor {

    override fun invoke(): Event {
        val champions = championsRepository.getChampions()
        return ChampionsEvent(champions)
    }

}