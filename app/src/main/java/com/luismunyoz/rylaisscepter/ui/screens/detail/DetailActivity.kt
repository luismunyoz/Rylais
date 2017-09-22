package com.luismunyoz.rylaisscepter.ui.screens.detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.luismunyoz.rylaisscepter.R
import com.luismunyoz.rylaisscepter.databinding.ActivityDetailBinding
import com.luismunyoz.rylaisscepter.di.ApplicationComponent
import com.luismunyoz.rylaisscepter.di.subcomponent.detail.DetailActivityModule
import com.luismunyoz.rylaisscepter.ui.activity.BaseActivity
import com.luismunyoz.rylaisscepter.ui.entity.UIChampion
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper
import com.luismunyoz.rylaisscepter.ui.util.getNavigationId
import javax.inject.Inject

/**
 * Created by Luis on 12/09/2017.
 */
class DetailActivity : BaseActivity(), DetailContract.View {

    companion object {
        val ARG_CHAMPION = "champion"
    }

    @Inject
    lateinit var uiChampionDataMapper : UIChampionDataMapper

    @Inject
    lateinit var presenter : DetailPresenter

    lateinit var uiChampion : UIChampion
    lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        uiChampion = intent?.extras?.get(ARG_CHAMPION) as UIChampion
        populateChampion(uiChampion)
    }

    override fun populateChampion(champion: UIChampion) {
        binding.item = champion
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(DetailActivityModule(this)).injectTo(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
        presenter.start(getNavigationId().toInt())
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }
}