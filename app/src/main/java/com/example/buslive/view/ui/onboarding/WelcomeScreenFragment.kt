package com.example.buslive.view.ui.onboarding

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.buslive.R

class WelcomeScreenFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_welcome_screen, container, false)

        ButterKnife.bind(this, v)

        return v
    }

    @OnClick(R.id.btn_goto_log_in)
    fun onStartLogin() {
        findNavController().navigate(R.id.action_welcomeScreenFragment_to_loginFragment)
    }

    @OnClick(R.id.btn_goto_sign_up)
    fun onStartSignUp() {
        findNavController().navigate(R.id.action_welcomeScreenFragment_to_registration_process)
    }
}
