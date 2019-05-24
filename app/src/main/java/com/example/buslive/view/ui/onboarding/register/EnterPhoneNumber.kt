package com.example.buslive.view.ui.onboarding.register


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.buslive.R

class EnterPhoneNumber : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_enter_phone_number, container, false)
        ButterKnife.bind(this, v)
        return v
    }

    @OnClick(R.id.btn_confirm_phone)
    fun onConfirmPhone() {
        findNavController().navigate(R.id.action_enterPhoneNumber_to_enterOTPCode)
    }

}
