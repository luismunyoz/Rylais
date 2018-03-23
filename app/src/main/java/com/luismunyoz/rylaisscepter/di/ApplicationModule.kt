package com.luismunyoz.rylaisscepter.di

import android.content.Context
import com.birbit.android.jobqueue.JobManager
import com.luismunyoz.rylaisscepter.App
import com.luismunyoz.rylaisscepter.domain.BusImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: App) {

    @Provides @Singleton
    fun provideApplication(): App = app

    @Provides @Singleton @ApplicationQualifier
    fun provideApplicationContext(): Context = app

}