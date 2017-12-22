package com.luismunyoz.rylaisscepter.data.riot.mapper

import com.luismunyoz.rylaisscepter.data.model.RiotBaseChampion
import com.luismunyoz.rylaisscepter.data.riot.model.RiotChampion
import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.entity.Champion

/**
 * Created by llco on 11/09/2017.
 */
class ChampionMapper {

    fun transform(championsMap: Map<String, RiotBaseChampion>) : List<BaseChampion> {
        return championsMap.mapNotNull { transform(it.value) }
    }

    fun transform(riotBaseChampion: RiotBaseChampion) : BaseChampion = BaseChampion(riotBaseChampion.id, riotBaseChampion.key, riotBaseChampion.name, riotBaseChampion.title, null, null, null, null, null)

    fun transform(champion: RiotChampion): Champion {
        return Champion(
                champion.id,
                champion.key,
                champion.name,
                champion.title,
                champion.lore,
                null,
                null,
                null,
                null
        )
    }
}