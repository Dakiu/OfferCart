package com.audienceview.offers.ui.offers.views

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.audienceview.offers.R
import com.audienceview.offers.databinding.OfferItemBinding
import com.audienceview.offers.ui.offers.interfaces.ClickRowOffer
import com.audienceview.offers.ui.offers.models.Items
import com.bumptech.glide.Glide

class OffersAdapter: RecyclerView.Adapter<OffersViewHolder>() {

    var hits = mutableListOf<Items>()
    var clickListener: ClickRowOffer?=null
    var inCart:Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OfferItemBinding.inflate(inflater, parent, false)
        return OffersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        var offerItem = hits[position]
        holder.binding.title.text =offerItem.title
        holder.binding.price.text = offerItem.price.toString()

        Glide.with(holder.itemView.context).load(offerItem.image).into(holder.binding.mediaContent)

        if (inCart){
            holder.binding.cart.setImageResource(R.drawable.ic_launcher_background)
        }else{
            holder.binding.cart.setImageResource(R.drawable.ic_baseline_cart_add)
        }

        holder.bind(offerItem, clickListener!!)
    }

    override fun getItemCount(): Int {
        return hits.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setOfferList(hits: List<Items>, clickNew: ClickRowOffer) {
        this.hits          = hits.toMutableList()
        this.clickListener = clickNew
        notifyDataSetChanged()
    }

}

class OffersViewHolder(var binding: OfferItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(of: Items, click: ClickRowOffer){
        binding.rowOffer = of
        binding.offerClick = click
        binding.executePendingBindings()
    }



}