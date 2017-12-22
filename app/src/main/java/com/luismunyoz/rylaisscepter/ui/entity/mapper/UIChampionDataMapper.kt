package com.luismunyoz.rylaisscepter.ui.entity.mapper

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.ui.entity.UIBaseChampion

/**
 * Created by llco on 11/09/2017.
 */
class UIChampionDataMapper {

    fun transform(baseChampion: BaseChampion) = UIBaseChampion(baseChampion.id, baseChampion.key, baseChampion.name, baseChampion.title, baseChampion.primaryColor, baseChampion.primaryTitleColor, baseChampion.primaryTextColor, baseChampion.lightColor, baseChampion.darkColor)

    fun transform(baseChampions: List<BaseChampion>) : List<UIBaseChampion> = baseChampions.map { transform(it) }

}