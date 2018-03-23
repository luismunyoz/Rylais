package com.luismunyoz.rylaisscepter.di.subcomponent.main

import com.luismunyoz.rylaisscepter.di.ActivityModule
import com.luismunyoz.rylaisscepter.di.scope.ActivityScope
import com.luismunyoz.rylaisscepter.domain.interactor.GetBaseChampionsInteractor
import com.luismunyoz.rylaisscepter.domain.interactor.UpdateBaseChampionInteractor
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper
import com.luismunyoz.rylaisscepter.ui.screens.main.MainActivity
import com.luismunyoz.rylaisscepter.ui.screens.main.MainContract
import com.luismunyoz.rylaisscepter.ui.screens.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by llco on 11/09/2017.
 */
@Module
class MainActivityModule(activity: MainActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideMainView(): MainContract.View = activity as MainContract.View

    @Provides @ActivityScope
    fun provideUIChampionMapper() = UIChampionDataMapper()

    @Provides @ActivityScope
    fun provideMainPresenter(view: MainContract.View, getBaseChampionsInteractor: GetBaseChampionsInteractor, updateBaseChampionInteractor: UpdateBaseChampionInteractor, uiChampionDataMapper: UIChampionDataMapper) =
            MainPresenter(view, getBaseChampionsInteractor, updateBaseChampionInteractor, uiChampionDataMapper)

}