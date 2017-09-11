package com.luismunyoz.rylaisscepter

import android.app.Application
import com.luismunyoz.rylaisscepter.di.ApplicationComponent
import com.luismunyoz.rylaisscepter.di.ApplicationModule
import com.luismunyoz.rylaisscepter.di.DaggerApplicationComponent

/**
 * Created by llco on 11/09/2017.
 */
class App : Application() {

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}