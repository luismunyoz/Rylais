package com.luismunyoz.rylaisscepter.repository

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository
import com.luismunyoz.rylaisscepter.repository.dataset.ChampionDataSet

/**
 * Created by llco on 11/09/2017.
 */
class ChampionRepositoryImpl(val championDataSets: List<ChampionDataSet>) : ChampionRepository {

    override fun getChampion(id: String): Champion? {
        var lastDataSet: ChampionDataSet? = null
        return championDataSets
                .filter {
                    it.isCacheValid()
                }
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

    override fun getBaseChampions(): List<BaseChampion> {
        var lastDataSet: ChampionDataSet? = null
        return championDataSets
                .filter {
                    it.isCacheValid()
                }
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
                .filter {
                    !it.isCacheValid()
                }
                .map {
                    it.store(champion)
                }
    }

    override fun storeBaseChampion(baseChampion: BaseChampion) {
        championDataSets
                .filter {
                    !it.isCacheValid()
                }
                .map {
                    it.store(baseChampion)
                }
    }
}