package com.luismunyoz.rylaisscepter.domain.entity

/**
 * Created by llco on 11/09/2017.
 */

class BaseChampion(
        val id: String,
        val key: String,
        val name: String,
        val title: String,
        var colors: ChampionUIColors?
)