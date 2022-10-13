package com.audienceview.offers.ui.offers.interfaces


import com.audienceview.offers.ui.offers.models.Items

interface ClickRowOffer {
    fun onGet(dataRow: Items)
}