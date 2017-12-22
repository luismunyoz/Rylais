package com.luismunyoz.rylaisscepter.data.local

import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.repository.dataset.ChampionDataSet

/**
 * Created by llco on 20/12/2017.
 */
class CacheChampionDataSet : ChampionDataSet {
    val champions : MutableList<Champion> = mutableListOf()

    override fun requestChampions(): List<Champion> = champions

    override fun requestChampion(id: String): Champion? {
        return champions.find { it.id == id }
    }

    override fun store(champion: Champion) {
        if (champion !in champions){
            champions.add(champion)
        }
    }

    override fun isCacheValid(): Boolean {
        return true
    }

}