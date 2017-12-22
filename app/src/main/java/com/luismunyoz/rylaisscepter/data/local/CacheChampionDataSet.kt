package com.luismunyoz.rylaisscepter.data.local

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.repository.dataset.ChampionDataSet

/**
 * Created by llco on 20/12/2017.
 */
class CacheChampionDataSet : ChampionDataSet {
    val baseChampions: MutableList<BaseChampion> = mutableListOf()

    override fun requestChampions(): List<BaseChampion> = baseChampions

    override fun requestChampion(id: String): Champion? {
        return baseChampions.find { it.id == id }
    }

    override fun store(baseChampion: BaseChampion) {
        if (baseChampion !in baseChampions){
            baseChampions.add(baseChampion)
        }
    }

    override fun isCacheValid(): Boolean {
        return true
    }

}