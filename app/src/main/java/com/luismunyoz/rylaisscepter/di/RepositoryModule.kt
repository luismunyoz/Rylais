package com.luismunyoz.rylaisscepter.di

import com.luismunyoz.rylaisscepter.data.CloudChampionDataSet
import com.luismunyoz.rylaisscepter.data.riot.RiotAPIService
import com.luismunyoz.rylaisscepter.domain.repository.ChampionRepository
import com.luismunyoz.rylaisscepter.repository.ChampionRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides @Singleton
    fun provideChampionsRepo(riotAPIService: RiotAPIService) : ChampionRepository
            = ChampionRepositoryImpl(listOf(CloudChampionDataSet(riotAPIService)))

}