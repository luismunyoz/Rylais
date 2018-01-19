package com.luismunyoz.rylaisscepter.data.firebase.model

import android.graphics.Color

/**
 * Created by llco on 20/12/2017.
 */

data class FBBaseChampion(
        val id: String = "",
        val key: String = "",
        val name: String = "",
        val title: String = "",
        val colors: FBChampionUIColors? = FBChampionUIColors()
    ) {
    val map: HashMap<String, Any?> by lazy {
        HashMap<String, Any?>().apply {
            put("id", id)
            put("key", key)
            put("name", name)
            put("title", title)
            put("colors", colors?.map)
        }
    }
}