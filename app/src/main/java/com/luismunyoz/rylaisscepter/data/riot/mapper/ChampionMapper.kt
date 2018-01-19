package com.luismunyoz.rylaisscepter.data.riot.mapper

import com.luismunyoz.rylaisscepter.data.model.RiotBaseChampion
import com.luismunyoz.rylaisscepter.data.riot.model.RiotAbility
import com.luismunyoz.rylaisscepter.data.riot.model.RiotChampion
import com.luismunyoz.rylaisscepter.data.riot.model.RiotChampionInfo
import com.luismunyoz.rylaisscepter.data.riot.model.RiotImage
import com.luismunyoz.rylaisscepter.domain.entity.*

/**
 * Created by llco on 11/09/2017.
 */
class ChampionMapper {

    fun transform(championsMap: Map<String, RiotBaseChampion>) : List<BaseChampion> {
        return championsMap.mapNotNull { transform(it.value) }
    }

    fun transform(riotBaseChampion: RiotBaseChampion) : BaseChampion = BaseChampion(riotBaseChampion.id, riotBaseChampion.key, riotBaseChampion.name, riotBaseChampion.title, null)


    fun transform(riotImage : RiotImage) : Image = Image(riotImage.full, riotImage.sprite, riotImage.group, riotImage.x, riotImage.y, riotImage.w, riotImage.h)

    fun transform(riotAbility: RiotAbility) : Ability = Ability(riotAbility.name, riotAbility.description, riotAbility.sanitizedDescription, transform(riotAbility.image))

    fun transform(riotChampionInfo: RiotChampionInfo) : ChampionInfo = ChampionInfo(riotChampionInfo.difficulty, riotChampionInfo.attack, riotChampionInfo.defense, riotChampionInfo.magic)

    fun transform(champion: RiotChampion): Champion {
        return Champion(
                champion.id,
                champion.key,
                champion.name,
                champion.title,
                champion.lore,
                transform(champion.info),
                transform(champion.image),
                transform(champion.passive),
                champion.spells.map { transform(it) }
        )
    }
}