package com.audienceview.offers.ui.offers.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OffersViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OffersViewModel::class.java)){
            return OffersViewModel() as T
        }

        throw IllegalArgumentException("Unknown class")
    }

}