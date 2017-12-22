package com.luismunyoz.rylaisscepter.data.firebase.mapper

import com.luismunyoz.rylaisscepter.data.firebase.model.FBBaseChampion
import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion

/**
 * Created by llco on 11/09/2017.
 */
class ChampionMapper {

    fun transform(firebaseBaseChampion: FBBaseChampion) : BaseChampion = BaseChampion(firebaseBaseChampion.id, firebaseBaseChampion.key, firebaseBaseChampion.name, firebaseBaseChampion.title, firebaseBaseChampion.primaryColor, firebaseBaseChampion.primaryTitleColor, firebaseBaseChampion.primaryTextColor, firebaseBaseChampion.lightColor, firebaseBaseChampion.darkColor)

    fun transform(baseChampion: BaseChampion) : FBBaseChampion = FBBaseChampion(baseChampion.id, baseChampion.key, baseChampion.name, baseChampion.title, baseChampion.primaryColor, baseChampion.primaryTitleColor, baseChampion.primaryTextColor, baseChampion.lightColor, baseChampion.darkColor)
}