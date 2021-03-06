package com.luismunyoz.rylaisscepter.di
import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.luismunyoz.rylaisscepter.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule(protected val activity: AppCompatActivity) {

    @Provides @ActivityScope
    fun provideActivity(): AppCompatActivity = activity

    @Provides @ActivityScope
    fun provideActiviyContext(): Context = activity.baseContext
}