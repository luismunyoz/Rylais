package com.luismunyoz.rylaisscepter.ui.screens.main

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.graphics.Palette
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.luismunyoz.rylaisscepter.R
import com.luismunyoz.rylaisscepter.di.ApplicationComponent
import com.luismunyoz.rylaisscepter.di.subcomponent.main.MainActivityModule
import com.luismunyoz.rylaisscepter.ui.activity.BaseActivity
import com.luismunyoz.rylaisscepter.ui.entity.UIChampion
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper
import com.luismunyoz.rylaisscepter.ui.screens.detail.DetailActivity
import com.luismunyoz.rylaisscepter.ui.screens.main.adapter.UIChampionsAdapter
import com.luismunyoz.rylaisscepter.ui.util.supportsLollipop
import javax.inject.Inject
import android.support.v4.util.Pair
import android.util.Log

class MainActivity : BaseActivity(), MainContract.View, UIChampionsAdapter.Callback {

    //@BindView(R.id.main_list)
    lateinit var list : RecyclerView

    @Inject
    lateinit var uiChampionDataMapper : UIChampionDataMapper

    @Inject
    lateinit var presenter : MainPresenter

    lateinit var adapter : UIChampionsAdapter

    var lastPressedImageView : ImageView? = null
    var lastPressedTextView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        list = findViewById(R.id.main_list)
        presenter.start()
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(MainActivityModule(this)).injectTo(this)
    }

    override fun populateItems(champions: List<UIChampion>) {
        adapter = UIChampionsAdapter(champions, this)
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list.adapter = adapter
    }

    override fun onChampionPressed(champion: UIChampion, imageView: ImageView, textView: TextView) {
        lastPressedImageView = imageView
        lastPressedTextView = textView
        presenter.onChampionPressed(champion.id)
    }

    override fun calculateColors(position: Int, champion: UIChampion) {
        Log.d("PALETTE", "Calculating color for ${champion.name}")
        Glide.with(this).load(champion.getSplashImageUrl()).asBitmap().into(object : SimpleTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
                Palette.from(resource).generate(object : Palette.PaletteAsyncListener {
                    override fun onGenerated(palette: Palette?) {
                        var primarySwatch : Palette.Swatch? = null
                        var lightSwatch : Palette.Swatch? = null
                        var darkSwatch : Palette.Swatch? = null

                        if(palette?.vibrantSwatch != null){
                            primarySwatch = palette.vibrantSwatch
                            if(palette.lightVibrantSwatch != null){
                                lightSwatch = palette.lightVibrantSwatch
                            }
                            if(palette.darkVibrantSwatch != null){
                                darkSwatch = palette.darkVibrantSwatch
                            }
                        } else if(palette?.mutedSwatch != null) {
                            primarySwatch = palette.mutedSwatch
                            if(palette.lightVibrantSwatch != null){
                                lightSwatch = palette.lightMutedSwatch
                            }
                            if(palette.darkVibrantSwatch != null){
                                darkSwatch = palette.darkMutedSwatch
                            }
                        }

                        primarySwatch?.let {
                            champion.primaryColor = it.rgb
                            champion.primaryTextColor = it.bodyTextColor
                            champion.primaryTitleColor = it.titleTextColor
                        }

                        lightSwatch?.let {
                            champion.lightColor = it.rgb
                        }

                        darkSwatch?.let {
                            champion.darkColor = it.rgb
                        }

                        adapter.updateItem(position, champion)
                        presenter.updateChampion(champion)
                    }
                })
            }
        })
    }

    @SuppressLint("NewApi")
    override fun goToChampionDetails(champion: UIChampion) {
        supportsLollipop {
            lastPressedImageView?.transitionName = "image"
            lastPressedTextView?.transitionName = "name"
        }

        champion.primaryColor?.let {
            window.setBackgroundDrawable(ColorDrawable(champion.primaryColor!!))
        }

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", champion.id)
        intent.putExtra(DetailActivity.ARG_CHAMPION, champion)

        var options: ActivityOptionsCompat? = null

        if (lastPressedImageView != null && lastPressedTextView != null) {
            val pair1 = Pair.create(lastPressedImageView!!, "image") as Pair<View, String>
            val pair2 = Pair.create(lastPressedTextView!!, "name") as Pair<View, String>
            options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pair1, pair2)
        }

        ActivityCompat.startActivity(this, intent, options?.toBundle())
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }
}
