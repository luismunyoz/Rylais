package com.luismunyoz.rylaisscepter.di

import com.luismunyoz.rylaisscepter.di.subcomponent.main.MainActivityComponent
import com.luismunyoz.rylaisscepter.di.subcomponent.main.MainActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        DataModule::class,
        RepositoryModule::class,
        DomainModule::class
))
interface ApplicationComponent {

    fun plus(module: MainActivityModule): MainActivityComponent

}