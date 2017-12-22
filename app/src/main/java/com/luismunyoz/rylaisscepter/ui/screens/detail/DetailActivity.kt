package com.luismunyoz.rylaisscepter.ui.screens.detail

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.Toolbar
import com.luismunyoz.rylaisscepter.R
import com.luismunyoz.rylaisscepter.databinding.ActivityDetailBinding
import com.luismunyoz.rylaisscepter.di.ApplicationComponent
import com.luismunyoz.rylaisscepter.di.subcomponent.detail.DetailActivityModule
import com.luismunyoz.rylaisscepter.ui.activity.BaseActivity
import com.luismunyoz.rylaisscepter.ui.entity.UIChampion
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper
import com.luismunyoz.rylaisscepter.ui.util.dpToPx
import com.luismunyoz.rylaisscepter.ui.util.getNavigationId
import com.luismunyoz.rylaisscepter.ui.util.supportsLollipop
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.backgroundColor
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
    lateinit var scrollview : NestedScrollView
    lateinit var toolbar : Toolbar
    lateinit var collapsingToolbar : CollapsingToolbarLayout
    lateinit var appBar : AppBarLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        scrollview = findViewById(R.id.detail_scroll)
        toolbar = findViewById(R.id.toolbar)
        collapsingToolbar = findViewById(R.id.collapsingtoolbar)
        appBar = findViewById(R.id.appbarlayout)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        uiChampion = intent?.extras?.get(ARG_CHAMPION) as UIChampion
        populateChampion(uiChampion)
        setViewEvents()
    }

    fun setViewEvents() {
        appBar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            internal var isShown = false
            internal var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(uiChampion.name)
                    isShown = true
                } else if (isShown) {
                    collapsingToolbar.setTitle(" ")//carefull there should a space between double quote otherwise it wont work
                    isShown = false
                }
            }
        })
    }

    @SuppressLint("NewApi")
    override fun populateChampion(champion: UIChampion) {
        supportsLollipop {
            uiChampion.primaryColor?.let {
                window.setBackgroundDrawable(ColorDrawable(it))
            }
            uiChampion.darkColor?.let {
                window.statusBarColor = it
            }
        }
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