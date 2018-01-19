package com.luismunyoz.rylaisscepter.data.firebase.model

/**
 * Created by llco on 22/12/2017.
 */
class FBImage(
        val full: String = "",
        val sprite: String = "",
        val group: String = "",
        val x: Int = 0,
        val y: Int = 0,
        val w: Int = 0,
        val h: Int = 0
){
    val map: HashMap<String, Any?> by lazy {
        HashMap<String, Any?>().apply {
            put("full", full)
            put("sprite", sprite)
            put("group", group)
            put("x", x)
            put("y", y)
            put("w", w)
            put("h", h)
        }
    }
}