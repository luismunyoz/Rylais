package com.luismunyoz.rylaisscepter.ui.screens.main

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.interactor.GetBaseChampionsInteractor
import com.luismunyoz.rylaisscepter.domain.interactor.UpdateBaseChampionInteractor
import com.luismunyoz.rylaisscepter.ui.entity.UIBaseChampion
import com.luismunyoz.rylaisscepter.ui.entity.mapper.UIChampionDataMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by llco on 11/09/2017.
 */
class MainPresenter(val view: MainContract.View,
                    val getBaseChampionsInteractor: GetBaseChampionsInteractor,
                    val storeBaseChampionInteractor: UpdateBaseChampionInteractor,
                    val uiChampionDataMapper: UIChampionDataMapper) : MainContract.Presenter {

    override val disposable : CompositeDisposable = CompositeDisposable()
    lateinit var baseChampions: List<BaseChampion>

    fun start() {
        downloadChampions()
    }

    fun downloadChampions() {
        disposable.add(
                getBaseChampionsInteractor
                    .invoke()
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { list ->
                        this.baseChampions = list
                        view.populateItems(uiChampionDataMapper.transform(baseChampions))
                    }
        )
    }

    override fun onChampionPressed(championId: String) {
        val champion = baseChampions.first { it.id.equals(championId) }
        view.goToChampionDetails(uiChampionDataMapper.transform(champion))
    }

    override fun updateChampion(uiBaseChampion: UIBaseChampion) {
        val champion = baseChampions.first { it.id.equals(uiBaseChampion.id) }
        uiBaseChampion.colors?.let {
            champion.colors = uiChampionDataMapper.transform(it)
            storeBaseChampionInteractor.baseChampion = champion

            disposable.add(
                    storeBaseChampionInteractor
                        .invoke()
                        .subscribeOn(Schedulers.computation())
                        .subscribe()
            )
        }
    }

}