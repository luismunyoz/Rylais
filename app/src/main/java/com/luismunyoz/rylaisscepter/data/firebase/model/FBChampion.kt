package com.luismunyoz.rylaisscepter.data.firebase.model

/**
 * Created by llco on 11/09/2017.
 */

class FBChampion(
        val id: String = "",
        val key: String = "",
        val name: String = "",
        val title: String = "",
        val lore: String = "",
        val info: FBChampionInfo = FBChampionInfo(),
        val image: FBImage = FBImage(),
        val passive: FBAbility = FBAbility(),
        val spells: List<FBAbility> = mutableListOf()
) {
    val map: HashMap<String, Any?> by lazy {
        HashMap<String, Any?>().apply {
            put("id", id)
            put("key", key)
            put("name", name)
            put("title", title)
            put("lore", lore)
            put("info", info)
            put("image", image.map)
            put("passive", passive.map)
            put("spells", spells.map { it.map })
        }
    }
}