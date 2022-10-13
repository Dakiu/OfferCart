package com.audienceview.offers.ui.offers.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.audienceview.offers.databinding.FragmentOffersBinding
import com.audienceview.offers.ui.offers.interfaces.ClickRowOffer
import com.audienceview.offers.ui.offers.models.Items
import com.audienceview.offers.ui.offers.viewmodels.OffersViewModel
import com.audienceview.offers.ui.offers.viewmodels.OffersViewModelFactory

class OffersFragment: Fragment(), ClickRowOffer {

    private lateinit var viewModel: OffersViewModel
    private lateinit var binding: FragmentOffersBinding

    private var totalIAmount:Int=0
    private var ItemsCart = mutableListOf<String>()

    val adapter = OffersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOffersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOffersBinding.inflate(layoutInflater)
        activity?.setContentView(binding.root)

        viewModel = ViewModelProvider(this, OffersViewModelFactory()).get(OffersViewModel::class.java)
        binding.rvMain.adapter = adapter

        viewModel.getOffers()?.observe(viewLifecycleOwner, Observer {
            adapter.setOfferList(it.items,this)
        })

    }

    override fun onGet(datarow: Items) {
        if (ItemsCart.contains(datarow.title)){
            ItemsCart.remove(datarow.title)
            totalIAmount -= datarow.price
        }else{
            ItemsCart.add(datarow.title)
            totalIAmount += datarow.price
        }

        binding.cartTotalItems.text ="Total Items: "+ItemsCart.size+" Amount: "+totalIAmount


    }


}