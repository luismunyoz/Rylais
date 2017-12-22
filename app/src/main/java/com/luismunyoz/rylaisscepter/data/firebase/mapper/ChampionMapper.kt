package com.luismunyoz.rylaisscepter.data.firebase.mapper

import com.luismunyoz.rylaisscepter.data.firebase.model.FBChampion
import com.luismunyoz.rylaisscepter.data.model.RiotChampion
import com.luismunyoz.rylaisscepter.domain.entity.Champion

/**
 * Created by llco on 11/09/2017.
 */
class ChampionMapper {

    fun transform(firebaseChampion: FBChampion) : Champion = Champion(firebaseChampion.id, firebaseChampion.key, firebaseChampion.name, firebaseChampion.title, firebaseChampion.primaryColor, firebaseChampion.primaryTitleColor, firebaseChampion.primaryTextColor, firebaseChampion.lightColor, firebaseChampion.darkColor)

    fun transform(champion : Champion) : FBChampion = FBChampion(champion.id, champion.key, champion.name, champion.title, champion.primaryColor, champion.primaryTitleColor, champion.primaryTextColor, champion.lightColor, champion.darkColor)
}