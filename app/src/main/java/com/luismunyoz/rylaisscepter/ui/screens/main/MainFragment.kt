package com.luismunyoz.rylaisscepter.ui.screens.main

import android.app.Fragment

/**
 * Created by llco on 11/09/2017.
 */
class MainFragment : Fragment(), MainContract.View {

    lateinit var pres : MainContract.Presenter

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.pres = presenter
    }
}