package com.luismunyoz.rylaisscepter.domain.entity


/**
 * Created by llco on 11/09/2017.
 */

class Champion(
        val id: String,
        val key: String,
        val name: String,
        val title: String,
        val lore: String,
        val info: ChampionInfo,
        val image: Image,
        val passive: Ability,
        val spells: List<Ability>
) {

}