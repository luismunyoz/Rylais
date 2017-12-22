package com.luismunyoz.rylaisscepter.domain.repository

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion


/**
 * Created by llco on 11/09/2017.
 */
interface ChampionRepository {

    fun getBaseChampions(): List<BaseChampion>

    fun getChampion(id: String) : BaseChampion?

    fun storeChampion(baseChampion: BaseChampion)

}