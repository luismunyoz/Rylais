package com.luismunyoz.rylaisscepter.data.firebase

import android.util.Log
import com.google.android.gms.tasks.Tasks
import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.repository.dataset.ChampionDataSet
import javax.inject.Inject
import com.google.firebase.firestore.FirebaseFirestore
import com.luismunyoz.rylaisscepter.BuildConfig
import com.luismunyoz.rylaisscepter.data.firebase.mapper.ChampionMapper
import com.luismunyoz.rylaisscepter.data.firebase.model.FBBaseChampion
import java.util.concurrent.TimeUnit


/**
 * Created by llco on 20/12/2017.
 */
class FirebaseChampionDataSet @Inject constructor(val firebaseDatabase: FirebaseFirestore) : ChampionDataSet {

    override fun requestChampions(): List<BaseChampion> {

        if(!isCacheValid()){
            return listOf()
        }

        val baseChampions: MutableList<FBBaseChampion> = mutableListOf()
        try {
            val task = firebaseDatabase.collection("basechampions").orderBy("name").get()
            Tasks.await(task, 5000, TimeUnit.MILLISECONDS)
            if (task.isSuccessful) {
                task.result.documents.forEach {
                    val champion = it.toObject(FBBaseChampion::class.java)
                    baseChampions.add(champion)
                }
                //latch.await()
                return baseChampions.map { ChampionMapper().transform(it) }
            }
        } catch (e: Exception) {
            Log.d("FIREBASE", "Error downloading baseChampions")
            e.printStackTrace()
        }
        return listOf()
    }

    override fun requestChampion(id: String): BaseChampion? {

        if(!isCacheValid()){
            return null
        }

        try {
            val task = firebaseDatabase.collection("baseChampions").document(id).get()
            Tasks.await(task, 500, TimeUnit.MILLISECONDS)
            if (task.isSuccessful) {
                return ChampionMapper().transform(task.result.toObject(FBBaseChampion::class.java))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    override fun store(baseChampion: BaseChampion) {
        val map = ChampionMapper().transform(baseChampion).map

        firebaseDatabase.collection("baseChampions").document(baseChampion.id)
                .set(map)

        firebaseDatabase.collection("configuration").document("cache").set(mapOf<String, Any>(Pair("lastUpdatedChampions", System.currentTimeMillis())))
    }

    override fun isCacheValid(): Boolean {
        try {
            val task = firebaseDatabase.collection("configuration").document("cache").get()
            Tasks.await(task, 1500, TimeUnit.MILLISECONDS)
            if(task.isSuccessful){
                val timestamp = task.result.getLong("lastUpdatedChampions")
                if (timestamp + BuildConfig.CACHE_TIME < System.currentTimeMillis()){
                    Log.d("FIREBASE", "Cache is invalid")
                    return false
                }
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
        Log.d("FIREBASE", "Cache is valid")
        return true
    }
}