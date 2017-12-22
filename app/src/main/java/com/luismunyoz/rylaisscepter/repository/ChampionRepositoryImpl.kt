package com.luismunyoz.rylaisscepter.repository

import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository
import com.luismunyoz.rylaisscepter.repository.dataset.ChampionDataSet
import java.util.function.Consumer

/**
 * Created by llco on 11/09/2017.
 */
class ChampionRepositoryImpl(val championDataSets: List<ChampionDataSet>) : ChampionRepository {
    override fun getChampion(id: String): Champion? {
        var lastDataSet: ChampionDataSet? = null
        return championDataSets
                .map {
                    lastDataSet = it
                    it.requestChampion(id)
                }
                .firstOrNull()
                .also {
                    championDataSets.filter { it != lastDataSet }.forEach { championDataSet ->
                        it?.let { championDataSet.store(it) }
                    }
                }
    }

    override fun getChampions(): List<Champion> {
        var lastDataSet: ChampionDataSet? = null
        return championDataSets
                .map {
                    lastDataSet = it
                    it.requestChampions()
                }
                .firstOrNull { it.isNotEmpty() }
                .also {
                    championDataSets.filter { it != lastDataSet }.forEach { championDataSet ->
                        it?.forEach { championDataSet.store(it) }
                    }
                }
                ?: emptyList()
    }

    override fun storeChampion(champion: Champion) {
        championDataSets
            .map {
                it.store(champion)
            }
    }
}