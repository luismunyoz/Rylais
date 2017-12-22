package com.luismunyoz.rylaisscepter.di

import com.luismunyoz.rylaisscepter.domain.interactor.GetChampionInteractor
import com.luismunyoz.rylaisscepter.domain.interactor.GetBaseChampionsInteractor
import com.luismunyoz.rylaisscepter.domain.interactor.UpdateChampionInteractor
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideChampionsInteractor(championsRepository: ChampionRepository)
            = GetBaseChampionsInteractor(championsRepository)

    @Provides
    fun provideChampionInteractor(championsRepository: ChampionRepository)
            = GetChampionInteractor(championsRepository)

    @Provides
    fun provideUpdateChampionInteractor(championsRepository: ChampionRepository)
            = UpdateChampionInteractor(championsRepository)
}