package com.luismunyoz.rylaisscepter.di

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.luismunyoz.rylaisscepter.BuildConfig
import com.luismunyoz.rylaisscepter.R
import com.luismunyoz.rylaisscepter.data.riot.RiotAPIRequestInterceptor
import com.luismunyoz.rylaisscepter.data.riot.RiotAPIService
import com.luismunyoz.rylaisscepter.di.qualifier.ApiKey
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Provides @Singleton
    fun provideCache(@ApplicationQualifier context: Context) = Cache(context.cacheDir, 10 * 1024 * 1024.toLong())

    @Provides @Singleton @ApiKey
    fun provideApiKey(@ApplicationQualifier context: Context): String = context.getString(R.string.riot_api_key)

    @Provides @Singleton
    fun provideOkHttpClient(cache: Cache, interceptor: RiotAPIRequestInterceptor): OkHttpClient =
            OkHttpClient().newBuilder()
                    .cache(cache)
                    .addInterceptor(interceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) Level.BODY else Level.NONE
                    })
                    .build()

    @Provides @Singleton
    fun provideRequestInterceptor(@ApiKey apiKey: String)
            = RiotAPIRequestInterceptor(apiKey)

    @Provides @Singleton
    fun provideRestAdapter(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://euw1.api.riotgames.com")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides @Singleton
    fun providesRiotAPIService(retrofit: Retrofit): RiotAPIService = retrofit.create(RiotAPIService::class.java)

    @Provides @Singleton
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()
}