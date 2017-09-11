package com.luismunyoz.rylaisscepter.repository.dataset

import com.luismunyoz.rylaisscepter.data.model.Champion

/**
 * Created by llco on 11/09/2017.
 */
interface ChampionDataSet {

    fun requestChampions() : List<Champion>

}