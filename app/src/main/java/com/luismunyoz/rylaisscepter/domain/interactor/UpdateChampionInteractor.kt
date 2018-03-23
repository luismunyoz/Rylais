package com.luismunyoz.rylaisscepter.domain.interactor

import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.domain.interactor.base.Interactor
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository
import io.reactivex.Single

/**
 * Created by llco on 11/09/2017.
 */
class UpdateChampionInteractor(val championsRepository: ChampionRepository) : Interactor<Boolean> {

    var champion: Champion? = null

    override fun invoke(): Single<Boolean> {
        val champion = this.champion ?: throw IllegalStateException("champion can´t be null")
        return Single.create { emitter ->
            championsRepository.storeChampion(champion)
            emitter.onSuccess(true)
        }
    }

}