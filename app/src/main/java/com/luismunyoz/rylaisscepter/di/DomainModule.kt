package com.luismunyoz.rylaisscepter.di

import com.luismunyoz.rylaisscepter.domain.interactor.GetChampionsInteractor
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideChampionsInteractor(championsRepository: ChampionRepository)
            = GetChampionsInteractor(championsRepository)
}