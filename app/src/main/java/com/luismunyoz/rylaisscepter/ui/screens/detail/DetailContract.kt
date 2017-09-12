package com.luismunyoz.rylaisscepter.ui.screens.detail

import com.luismunyoz.rylaisscepter.ui.entity.UIChampion
import com.luismunyoz.rylaisscepter.ui.util.BaseContract

/**
 * Created by llco on 11/09/2017.
 */
interface DetailContract {

    interface View : BaseContract.BaseView<Presenter> {

        fun populateChampion(champion: UIChampion)

    }

    interface Presenter : BaseContract.BasePresenter {

    }
}