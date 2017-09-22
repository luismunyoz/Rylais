package com.luismunyoz.rylaisscepter.ui.screens.main

import com.luismunyoz.rylaisscepter.ui.entity.UIChampion
import com.luismunyoz.rylaisscepter.ui.util.BaseContract

/**
 * Created by llco on 11/09/2017.
 */
interface MainContract {

    interface View : BaseContract.BaseView<Presenter> {

        fun populateItems(champions: List<UIChampion>)

        fun goToChampionDetails(champion: UIChampion)

    }

    interface Presenter : BaseContract.BasePresenter {

        fun onChampionPressed(championId: String)
    }
}