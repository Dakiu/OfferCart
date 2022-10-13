package com.audienceview.offers.utils

import com.audienceview.offers.ui.offers.models.network.OffersAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val MainServer = "https://us-central1-techtaskapi.cloudfunctions.net/offers/"


    val retrofitClient: Retrofit.Builder by lazy {

        Retrofit.Builder()
            .baseUrl(MainServer)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())

    }

    val apiInterface: OffersAPI by lazy {
        retrofitClient
            .build()
            .create(OffersAPI::class.java)
    }

}