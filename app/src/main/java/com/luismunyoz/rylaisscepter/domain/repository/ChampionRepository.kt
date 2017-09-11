package com.luismunyoz.rylaisscepter.domain.repository

import com.luismunyoz.rylaisscepter.data.model.Champion

/**
 * Created by llco on 11/09/2017.
 */
interface ChampionRepository {

    fun getChampions(): List<Champion>

}