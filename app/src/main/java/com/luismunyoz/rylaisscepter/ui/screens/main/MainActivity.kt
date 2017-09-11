package com.luismunyoz.rylaisscepter.ui.screens.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.luismunyoz.rylaisscepter.R
import com.luismunyoz.rylaisscepter.di.ApplicationComponent
import com.luismunyoz.rylaisscepter.di.subcomponent.main.MainActivityModule
import com.luismunyoz.rylaisscepter.ui.activity.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(MainActivityModule(this)).injectTo(this)
    }

}
