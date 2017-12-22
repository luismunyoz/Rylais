package com.luismunyoz.rylaisscepter.ui.screens.main

import com.luismunyoz.rylaisscepter.ui.entity.UIBaseChampion
import com.luismunyoz.rylaisscepter.ui.util.BaseContract

/**
 * Created by llco on 11/09/2017.
 */
interface MainContract {

    interface View : BaseContract.BaseView<Presenter> {

        fun populateItems(baseChampions: List<UIBaseChampion>)

        fun goToChampionDetails(baseChampion: UIBaseChampion)

    }

    interface Presenter : BaseContract.BasePresenter {

        fun onChampionPressed(championId: String)

        fun updateChampion(uiBaseChampion: UIBaseChampion)
    }
}