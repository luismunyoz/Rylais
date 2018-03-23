package com.luismunyoz.rylaisscepter.domain.interactor

import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.domain.interactor.base.Interactor
import com.luismunyoz.rylaisscepter.domain.interactor.error.ChampionNotFoundError
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository
import io.reactivex.Single

/**
 * Created by llco on 11/09/2017.
 */
class GetChampionInteractor(val championsRepository: ChampionRepository) : Interactor<Champion> {

    var id: String? = null

    override fun invoke(): Single<Champion> {
        val id = this.id ?: throw IllegalStateException("id can´t be null")

        return Single.create<Champion> { emitter ->
            val champion = championsRepository.getChampion(id)
            if (champion != null) {
                emitter.onSuccess(champion)
            } else {
                emitter.onError(ChampionNotFoundError())
            }
        }
    }



}