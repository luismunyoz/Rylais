package com.luismunyoz.rylaisscepter.domain.interactor

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.interactor.base.Interactor
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository
import io.reactivex.Single

/**
 * Created by llco on 11/09/2017.
 */
class UpdateBaseChampionInteractor(val championsRepository: ChampionRepository) : Interactor<Boolean> {

    var baseChampion: BaseChampion? = null

    override fun invoke(): Single<Boolean> {
        val champion = this.baseChampion ?: throw IllegalStateException("baseChampion can´t be null")
        return Single.create<Boolean> { emitter ->
            championsRepository.storeBaseChampion(champion)
            emitter.onSuccess(true)
        }
    }

}