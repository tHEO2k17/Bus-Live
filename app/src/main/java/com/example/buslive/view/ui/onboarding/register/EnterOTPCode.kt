package com.example.buslive.view.ui.onboarding.register


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.internal.ListenerClass
import com.example.buslive.R
import com.mukesh.OtpView

class EnterOTPCode : Fragment() {

    @BindView(R.id.otp_view)
    lateinit var otp: OtpView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_enter_otpcode, container, false)
        ButterKnife.bind(this, v)

        otp.setOtpCompletionListener {
            findNavController().navigate(R.id.action_enterOTPCode_to_enterDetailsFragment)
        }

        return v
    }

}
