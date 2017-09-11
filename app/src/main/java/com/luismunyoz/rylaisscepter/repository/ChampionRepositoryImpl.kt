package com.luismunyoz.rylaisscepter.repository

import com.luismunyoz.rylaisscepter.data.model.Champion
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository
import com.luismunyoz.rylaisscepter.repository.dataset.ChampionDataSet

/**
 * Created by llco on 11/09/2017.
 */
class ChampionRepositoryImpl(val championDataSets: List<ChampionDataSet>) : ChampionRepository {

    override fun getChampions(): List<Champion> = championDataSets
            .map { it.requestChampions() }
            .firstOrNull { it.isNotEmpty() }
            ?: emptyList()
}