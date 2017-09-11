package com.luismunyoz.rylaisscepter.data.model

/**
 * Created by llco on 11/09/2017.
 */
class RiotStaticDataResponse (
        val data: Map<String, RiotChampion>,
        val type: String,
        val version: String
)