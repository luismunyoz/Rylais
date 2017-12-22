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
        var primaryColor: Int? = null,
        var primaryTitleColor: Int? = null,
        var primaryTextColor: Int? = null,
        var lightColor: Int? = null,
        var darkColor: Int? = null
    ) {
    val map: HashMap<String, Any?> by lazy {
        HashMap<String, Any?>().apply {
            put("id", id)
            put("key", key)
            put("name", name)
            put("title", title)
            put("primaryColor", primaryColor)
            put("primaryTitleColor", primaryTitleColor)
            put("primaryTextColor", primaryTextColor)
            put("lightColor", lightColor)
            put("darkColor", darkColor)
        }
    }
}