package com.luismunyoz.rylaisscepter.domain.repository

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.entity.Champion


/**
 * Created by llco on 11/09/2017.
 */
interface ChampionRepository {

    fun getBaseChampions(): List<BaseChampion>

    fun getChampion(id: String) : Champion?

    fun storeBaseChampion(baseChampion: BaseChampion)

    fun storeChampion(champion: Champion)

}