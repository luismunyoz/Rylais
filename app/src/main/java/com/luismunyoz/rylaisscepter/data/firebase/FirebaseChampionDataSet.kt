package com.luismunyoz.rylaisscepter.data.firebase

import android.app.AlarmManager
import android.util.Log
import com.google.android.gms.tasks.Tasks
import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.repository.dataset.ChampionDataSet
import javax.inject.Inject
import com.google.firebase.firestore.FirebaseFirestore
import com.luismunyoz.rylaisscepter.BuildConfig
import com.luismunyoz.rylaisscepter.data.firebase.mapper.ChampionMapper
import com.luismunyoz.rylaisscepter.data.firebase.model.FBChampion
import java.util.concurrent.TimeUnit


/**
 * Created by llco on 20/12/2017.
 */
class FirebaseChampionDataSet @Inject constructor(val firebaseDatabase: FirebaseFirestore) : ChampionDataSet {

    override fun requestChampions(): List<Champion> {

        if(!isCacheValid()){
            return listOf()
        }

        val champions : MutableList<FBChampion> = mutableListOf()
        try {
            val task = firebaseDatabase.collection("champions").orderBy("name").get()
            Tasks.await(task, 5000, TimeUnit.MILLISECONDS)
            if (task.isSuccessful) {
                task.result.documents.forEach {
                    val champion = it.toObject(FBChampion::class.java)
                    champions.add(champion)
                }
                //latch.await()
                return champions.map { ChampionMapper().transform(it) }
            }
        } catch (e: Exception) {
            Log.d("FIREBASE", "Error downloading champions")
            e.printStackTrace()
        }
        return listOf()
    }

    override fun requestChampion(id: String): Champion? {

        if(!isCacheValid()){
            return null
        }

        try {
            val task = firebaseDatabase.collection("champions").document(id).get()
            Tasks.await(task, 500, TimeUnit.MILLISECONDS)
            if (task.isSuccessful) {
                return ChampionMapper().transform(task.result.toObject(FBChampion::class.java))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    override fun store(champion: Champion) {
        val map = ChampionMapper().transform(champion).map

        firebaseDatabase.collection("champions").document(champion.id)
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