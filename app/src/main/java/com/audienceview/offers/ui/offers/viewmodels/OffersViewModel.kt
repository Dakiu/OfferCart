package com.audienceview.offers.ui.offers.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.audienceview.offers.ui.offers.models.Offer
import com.audienceview.offers.ui.offers.repository.Repository

class OffersViewModel: ViewModel() {

    var offerLiveData: MutableLiveData<Offer>?=null

    fun getOffers(): LiveData<Offer>?{

        offerLiveData = Repository.getServiceApiCall()

        return offerLiveData

    }







}