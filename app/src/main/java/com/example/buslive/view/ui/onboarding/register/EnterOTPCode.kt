package com.example.buslive.view.ui.onboarding.register


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.internal.ListenerClass
import com.example.buslive.R
import com.mukesh.OtpView

class EnterOTPCode : Fragment() {

    @BindView(R.id.otp_view)
    lateinit var otp: OtpView

    @BindView(R.id.tv_ins)
    lateinit var mInstructions: TextView

    private val args: EnterOTPCodeArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_enter_otpcode, container, false)
        ButterKnife.bind(this, v)

        mInstructions.text = mInstructions.text.replace("\\+233 000 000 000".toRegex(), args.phone)

        otp.setOtpCompletionListener {
            val action = EnterOTPCodeDirections.actionEnterOTPCodeToEnterDetailsFragment(args.phone)
            findNavController().navigate(action)
        }

        return v
    }

}
