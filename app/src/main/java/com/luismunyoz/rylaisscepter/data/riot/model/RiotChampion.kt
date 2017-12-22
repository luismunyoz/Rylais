package com.luismunyoz.rylaisscepter.data.riot.model

/**
 * Created by llco on 11/09/2017.
 */

class RiotChampion(
        val id: String,
        val key: String,
        val name: String,
        val title: String,
        val lore: String,
        val info: RiotChampionInfo,
        val image: RiotImage,
        val passive: RiotAbility,
        val spells: List<RiotAbility>
) {

}