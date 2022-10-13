package com.audienceview.offers.ui.offers.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.audienceview.offers.ui.offers.models.Offer
import com.audienceview.offers.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {

    val offerItems = MutableLiveData<Offer>()

    fun getServiceApiCall(): MutableLiveData<Offer>{

        val call = RetrofitClient.apiInterface.getOffers()

        call?.enqueue(object: Callback<Offer>{

            override fun onFailure(call: Call<Offer>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(call: Call<Offer>, response: Response<Offer>) {
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()
                offerItems.value = data!!
            }

        })

        return  offerItems
    }
}