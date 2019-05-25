package com.example.buslive.view.ui.main.booking


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.buslive.R

class EnterTripDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_enter_trip_details, container, false)
        ButterKnife.bind(this, v)
        return v
    }

    @OnClick(R.id.btn_search)
    fun onSearchBus() {
        findNavController().navigate(R.id.action_enterTripDetailsFragment_to_availableBusesFragment)
    }


}
