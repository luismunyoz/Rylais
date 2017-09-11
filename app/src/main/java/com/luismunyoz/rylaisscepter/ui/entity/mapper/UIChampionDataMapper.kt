package com.luismunyoz.rylaisscepter.ui.entity.mapper

import com.luismunyoz.rylaisscepter.data.model.Champion
import com.luismunyoz.rylaisscepter.ui.entity.UIChampion

/**
 * Created by llco on 11/09/2017.
 */
class UIChampionDataMapper {

    fun transform(champion: Champion) = UIChampion(champion.id, champion.key, champion.name, champion.title)

}