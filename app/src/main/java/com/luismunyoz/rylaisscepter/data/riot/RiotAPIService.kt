package com.luismunyoz.rylaisscepter.data.riot

import com.luismunyoz.rylaisscepter.data.model.RiotStaticDataResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by llco on 11/09/2017.
 */
interface RiotAPIService {

    @GET("/lol/static-data/v3/champions")
    fun getChampions() : Call<RiotStaticDataResponse>
}