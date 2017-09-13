package com.luismunyoz.rylaisscepter.ui.screens.detail

import com.luismunyoz.rylaisscepter.di.ApplicationComponent
import com.luismunyoz.rylaisscepter.di.subcomponent.detail.DetailActivityModule
import com.luismunyoz.rylaisscepter.ui.activity.BaseActivity
import com.luismunyoz.rylaisscepter.ui.entity.UIChampion
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper
import javax.inject.Inject

/**
 * Created by Luis on 12/09/2017.
 */
class DetailActivity : BaseActivity(), DetailContract.View {

    @Inject
    lateinit var uiChampionDataMapper : UIChampionDataMapper

    @Inject
    lateinit var presenter : DetailPresenter



    override fun populateChampion(champion: UIChampion) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(DetailActivityModule(this)).injectTo(this)
    }
}