package com.luismunyoz.rylaisscepter.ui.entity.mapper

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.entity.ChampionUIColors
import com.luismunyoz.rylaisscepter.ui.entity.UIBaseChampion
import com.luismunyoz.rylaisscepter.ui.entity.UIChampionColors

/**
 * Created by llco on 11/09/2017.
 */
class UIChampionDataMapper {

    fun transform(uiChampionColors: UIChampionColors) : ChampionUIColors = ChampionUIColors(uiChampionColors.primaryColor, uiChampionColors.primaryTitleColor, uiChampionColors.primaryTextColor, uiChampionColors.lightColor, uiChampionColors.darkColor)

    fun transform(championUIColors: ChampionUIColors) : UIChampionColors = UIChampionColors(championUIColors.primaryColor, championUIColors.primaryTitleColor, championUIColors.primaryTextColor, championUIColors.lightColor, championUIColors.darkColor)

    fun transform(baseChampion: BaseChampion) : UIBaseChampion {
        val colors : ChampionUIColors? = baseChampion.colors
        if(colors != null) {
            return UIBaseChampion(baseChampion.id, baseChampion.key, baseChampion.name, baseChampion.title, transform(colors))
        } else {
            return UIBaseChampion(baseChampion.id, baseChampion.key, baseChampion.name, baseChampion.title, null)
        }
    }

    fun transform(baseChampions: List<BaseChampion>) : List<UIBaseChampion> = baseChampions.map { transform(it) }

}