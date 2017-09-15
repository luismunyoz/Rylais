package com.luismunyoz.rylaisscepter.repository.dataset

import com.luismunyoz.rylaisscepter.domain.entity.Champion


/**
 * Created by llco on 11/09/2017.
 */
interface ChampionDataSet {

    fun requestChampions() : List<Champion>

    fun requestChampion(id: String) : Champion

}