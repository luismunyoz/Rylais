package com.luismunyoz.rylaisscepter.ui.entity

import java.io.Serializable

/**
 * Created by llco on 11/09/2017.
 */

class UIBaseChampion(
        val id: String,
        val key: String,
        val name: String,
        val title: String,
        var primaryColor: Int?,
        var primaryTitleColor: Int?,
        var primaryTextColor: Int?,
        var lightColor: Int?,
        var darkColor: Int?
) : Serializable {
    fun getLoadingImageUrl() : String {
        return "http://ddragon.leagueoflegends.com/cdn/img/baseChampion/loading/${key}_0.jpg"
    }

    fun getSquareImageUrl() : String {
        return "http://ddragon.leagueoflegends.com/cdn/6.24.1/img/baseChampion/${key}.png"
    }

    fun getSplashImageUrl() : String {
        return "http://ddragon.leagueoflegends.com/cdn/img/baseChampion/splash/${key}_0.jpg"
    }
}