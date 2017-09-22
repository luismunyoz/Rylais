package com.luismunyoz.rylaisscepter.ui.screens.main

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.luismunyoz.rylaisscepter.R
import com.luismunyoz.rylaisscepter.di.ApplicationComponent
import com.luismunyoz.rylaisscepter.di.subcomponent.main.MainActivityModule
import com.luismunyoz.rylaisscepter.ui.activity.BaseActivity
import com.luismunyoz.rylaisscepter.ui.entity.UIChampion
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper
import com.luismunyoz.rylaisscepter.ui.screens.detail.DetailActivity
import com.luismunyoz.rylaisscepter.ui.screens.main.adapter.UIChampionsAdapter
import com.luismunyoz.rylaisscepter.ui.util.navigate
import com.luismunyoz.rylaisscepter.ui.util.supportsLollipop
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View, UIChampionsAdapter.Callback {

    //@BindView(R.id.main_list)
    lateinit var list : RecyclerView

    @Inject
    lateinit var uiChampionDataMapper : UIChampionDataMapper

    @Inject
    lateinit var presenter : MainPresenter

    lateinit var adapter : UIChampionsAdapter

    var lastPressedImageView : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        list = findViewById(R.id.main_list)
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(MainActivityModule(this)).injectTo(this)
    }

    override fun populateItems(champions: List<UIChampion>) {
        adapter = UIChampionsAdapter(champions, this)
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list.adapter = adapter
    }

    override fun onChampionPressed(champion: UIChampion, imageView: ImageView) {
        lastPressedImageView = imageView
        presenter.onChampionPressed(champion.id)
    }

    override fun goToChampionDetails(champion: UIChampion) {
        supportsLollipop { lastPressedImageView?.transitionName = "image" }

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", champion.id)
        intent.putExtra(DetailActivity.ARG_CHAMPION, champion)

        var options: ActivityOptionsCompat? = null

        if (lastPressedImageView != null) {
            options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, lastPressedImageView, "image")
        }

        ActivityCompat.startActivity(this, intent, options?.toBundle())
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
        presenter.start()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }
}
