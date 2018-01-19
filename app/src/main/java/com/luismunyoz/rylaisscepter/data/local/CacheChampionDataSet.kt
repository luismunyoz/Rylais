package com.luismunyoz.rylaisscepter.data.local

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.repository.dataset.ChampionDataSet

/**
 * Created by llco on 20/12/2017.
 */
class CacheChampionDataSet : ChampionDataSet {

    val baseChampions: MutableList<BaseChampion> = mutableListOf()
    val champions: MutableList<Champion> = mutableListOf()

    override fun requestChampions() = baseChampions

    override fun requestChampion(id: String): Champion? {
        return champions.find { it.id == id }
    }

    override fun store(baseChampion: BaseChampion) {
        var found = false
        for (bs in baseChampions){
            if(bs.id == baseChampion.id){
                bs.colors = baseChampion.colors
                found = true
                break
            }
        }
        if (!found){
            baseChampions.add(baseChampion)
        }
    }

    override fun store(champion: Champion) {
        if (champion !in champions){
            champions.add(champion)
        }
    }

    override fun isCacheValid(): Boolean {
        return false
    }

}