package com.luismunyoz.rylaisscepter.repository.dataset

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.entity.Champion


/**
 * Created by llco on 11/09/2017.
 */
interface ChampionDataSet {

    fun requestChampions() : List<BaseChampion>

    fun requestChampion(id: String) : Champion?

    fun store(baseChampion: BaseChampion)

    fun store(champion: Champion)

    fun isCacheValid() : Boolean

}