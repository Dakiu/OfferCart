package com.audienceview.offers.ui.offers.models

data class Offer (

    val page: Int,
    val pageSize: Int,
    val total:Int,
    val items: List<Items>
    )

data class Items(
    val id:String,
    val title: String,
    val image: String?,
    val price:Int
)