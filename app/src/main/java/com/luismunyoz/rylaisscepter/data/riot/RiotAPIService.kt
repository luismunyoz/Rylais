package com.luismunyoz.rylaisscepter.data.riot

import com.luismunyoz.rylaisscepter.data.model.RiotBaseChampion
import com.luismunyoz.rylaisscepter.data.model.RiotStaticDataResponse
import com.luismunyoz.rylaisscepter.data.riot.model.RiotChampion
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by llco on 11/09/2017.
 */
interface RiotAPIService {

    @GET("/lol/static-data/v3/champions")
    fun getChampions() : Call<RiotStaticDataResponse>

    @GET("/lol/static-data/v3/champions/{id}?tags=image&tags=info&tags=lore&tags=passive&tags=skins&tags=spells&tags=stats")
    fun getChampion(@Query("id") id : String) : Call<RiotChampion>
}