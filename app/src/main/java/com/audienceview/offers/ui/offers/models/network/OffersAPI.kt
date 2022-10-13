package com.audienceview.offers.ui.offers.models.network

import com.audienceview.offers.ui.offers.models.Offer
import com.audienceview.offers.utils.Constants
import retrofit2.Call
import retrofit2.http.GET

interface OffersAPI {

    @GET(Constants.API_ENDPOINT)
    fun getOffers(): Call<Offer>

}