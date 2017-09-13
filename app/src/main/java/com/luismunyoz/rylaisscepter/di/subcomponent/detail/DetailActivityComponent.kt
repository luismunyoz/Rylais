package com.luismunyoz.rylaisscepter.di.subcomponent.detail

import com.luismunyoz.rylaisscepter.di.scope.ActivityScope
import com.luismunyoz.rylaisscepter.ui.screens.detail.DetailActivity
import dagger.Subcomponent

/**
 * Created by Luis on 13/09/2017.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(
        DetailActivityModule::class
))
interface DetailActivityComponent {

    fun injectTo(activity: DetailActivity)
}