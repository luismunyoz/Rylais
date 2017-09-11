package com.luismunyoz.rylaisscepter.di.subcomponent.main

import com.luismunyoz.rylaisscepter.di.ActivityModule
import com.luismunyoz.rylaisscepter.di.scope.ActivityScope
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper
import com.luismunyoz.rylaisscepter.ui.screens.main.MainActivity
import dagger.Module
import dagger.Provides

/**
 * Created by llco on 11/09/2017.
 */
@Module
class MainActivityModule(activity: MainActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideUIChampionMapper() = UIChampionDataMapper()
}