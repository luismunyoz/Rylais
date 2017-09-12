package com.luismunyoz.rylaisscepter.ui.entity

/**
 * Created by llco on 11/09/2017.
 */

class UIChampion(
        val id: String,
        val key: String,
        val name: String,
        val title: String
) {
    fun getLoadingImageUrl() : String {
        return "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${key}_0.jpg"
    }

    fun getSquareImageUrl() : String {
        return "http://ddragon.leagueoflegends.com/cdn/6.24.1/img/champion/${key}.png"
    }

    fun getSplashImageUrl() : String {
        return "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/${key}_0.jpg"
    }
}