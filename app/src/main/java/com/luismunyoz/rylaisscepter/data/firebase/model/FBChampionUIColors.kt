package com.luismunyoz.rylaisscepter.data.firebase.model

/**
 * Created by llco on 19/01/2018.
 */
class FBChampionUIColors(
        var primaryColor: Int? = null,
        var primaryTitleColor: Int? = null,
        var primaryTextColor: Int? = null,
        var lightColor: Int? = null,
        var darkColor: Int? = null
){
    val map: HashMap<String, Any?> by lazy {
        HashMap<String, Any?>().apply {
            put("primaryColor", primaryColor)
            put("primaryTitleColor", primaryTitleColor)
            put("primaryTextColor", primaryTextColor)
            put("lightColor", lightColor)
            put("darkColor", darkColor)
        }
    }
}