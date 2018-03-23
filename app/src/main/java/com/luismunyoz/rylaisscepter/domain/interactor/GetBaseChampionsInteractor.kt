package com.luismunyoz.rylaisscepter.domain.interactor

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.interactor.base.Interactor
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository
import io.reactivex.Single

/**
 * Created by llco on 11/09/2017.
 */
class GetBaseChampionsInteractor(val championsRepository: ChampionRepository) : Interactor<List<BaseChampion>> {

    override fun invoke(): Single<List<BaseChampion>> {
        return Single.create<List<BaseChampion>> { emitter ->
            val champions = championsRepository.getBaseChampions()
            emitter.onSuccess(champions)
        }
    }

}