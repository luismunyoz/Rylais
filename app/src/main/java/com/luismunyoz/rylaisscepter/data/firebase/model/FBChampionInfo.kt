package com.luismunyoz.rylaisscepter.data.firebase.model

/**
 * Created by llco on 22/12/2017.
 */
class FBChampionInfo(
        val difficulty: Int = 0,
        val attack: Int = 0,
        val defense: Int = 0,
        val magic: Int = 0
){
    val map: HashMap<String, Any?> by lazy {
        HashMap<String, Any?>().apply {
            put("difficulty", difficulty)
            put("attack", attack)
            put("defense", defense)
            put("magic", magic)
        }
    }
}