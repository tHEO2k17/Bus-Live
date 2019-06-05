package com.example.buslive.view.ui.onboarding.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.buslive.R

class LoginFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_login, container, false)
         ButterKnife.bind(this, v)
        return v
    }

    @OnClick(R.id.btn_login)
    fun onLogin(){
        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
    }

}
