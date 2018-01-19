package com.luismunyoz.rylaisscepter.data

import com.luismunyoz.rylaisscepter.data.riot.mapper.ChampionMapper
import com.luismunyoz.rylaisscepter.data.riot.RiotAPIService
import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.repository.dataset.ChampionDataSet

/**
 * Created by llco on 11/09/2017.
 */
class CloudChampionDataSet(val riotAPIService: RiotAPIService) : ChampionDataSet {

    override fun requestChampion(id: String): Champion? =
            riotAPIService.getChampion(id).unwrapCall { ChampionMapper().transform(this) }

    override fun requestChampions(): List<BaseChampion> =
        riotAPIService.getChampions().unwrapCall {
            ChampionMapper().transform(data)
        } ?: emptyList()

    override fun store(baseChampion: BaseChampion) {
    }

    override fun store(champion: Champion) {
    }

    override fun isCacheValid(): Boolean = true

}