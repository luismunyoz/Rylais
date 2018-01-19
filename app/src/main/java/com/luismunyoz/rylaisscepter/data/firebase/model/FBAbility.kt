package com.luismunyoz.rylaisscepter.data.firebase.model

/**
 * Created by llco on 22/12/2017.
 */
class FBAbility(
        val name: String = "",
        val description: String = "",
        val sanitizedDescription: String = "",
        val image: FBImage = FBImage()
){
    val map: HashMap<String, Any?> by lazy {
        HashMap<String, Any?>().apply {
            put("name", name)
            put("description", description)
            put("sanitizedDescription", sanitizedDescription)
            put("image", image.map)
        }
    }
}