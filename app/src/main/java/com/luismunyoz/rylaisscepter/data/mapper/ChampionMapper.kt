package com.luismunyoz.rylaisscepter.data.mapper

import com.luismunyoz.rylaisscepter.data.model.Champion
import com.luismunyoz.rylaisscepter.data.model.RiotChampion

/**
 * Created by llco on 11/09/2017.
 */
class ChampionMapper {

    fun transform(championsMap: Map<String, RiotChampion>) : List<Champion> {
        return championsMap.mapNotNull { transform(it.value) }
    }

    fun transform(riotChampion: RiotChampion) : Champion = Champion(riotChampion.id, riotChampion.key, riotChampion.name, riotChampion.title)
}