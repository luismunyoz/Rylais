package com.luismunyoz.rylaisscepter.di.subcomponent.detail

import com.luismunyoz.rylaisscepter.di.ActivityModule
import com.luismunyoz.rylaisscepter.di.scope.ActivityScope
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper
import com.luismunyoz.rylaisscepter.ui.screens.detail.DetailActivity
import com.luismunyoz.rylaisscepter.ui.screens.detail.DetailContract
import com.luismunyoz.rylaisscepter.ui.screens.detail.DetailPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Luis on 12/09/2017.
 */
@Module
class DetailActivityModule(activity: DetailActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideDetailView(): DetailContract.View = activity as DetailContract.View

    @Provides @ActivityScope
    fun provideUIChampionMapper() = UIChampionDataMapper()

    @Provides @ActivityScope
    fun provideDetailPresenter(view: DetailContract.View, uiChampionDataMapper: UIChampionDataMapper) =
            DetailPresenter(view, uiChampionDataMapper)
}