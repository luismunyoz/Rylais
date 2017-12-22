package com.luismunyoz.rylaisscepter.ui.screens.detail

import com.luismunyoz.rylaisscepter.ui.entity.UIBaseChampion
import com.luismunyoz.rylaisscepter.ui.util.BaseContract

/**
 * Created by llco on 11/09/2017.
 */
interface DetailContract {

    interface View : BaseContract.BaseView<Presenter> {

        fun populateChampion(baseChampion: UIBaseChampion)

    }

    interface Presenter : BaseContract.BasePresenter {

    }
}