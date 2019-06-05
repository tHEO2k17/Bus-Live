package com.example.buslive.view.ui.onboarding.register


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.navigation.fragment.findNavController
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.buslive.R
import com.mobsandgeeks.saripaar.ValidationError
import com.mobsandgeeks.saripaar.Validator
import com.mobsandgeeks.saripaar.annotation.Pattern

class EnterPhoneNumber : Fragment(), Validator.ValidationListener {

    @Pattern(
        regex = "(0+[52]|\\+2332|\\+2335)+\\d{8}",
        message = "Enter a valid number (eg. 0205779884 or 0505779884 or 233577880222)"
    )
    @BindView(R.id.edt_phone)
    lateinit var mPhone: AppCompatEditText

    private val validator: Validator by lazy { Validator(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_enter_phone_number, container, false)
        ButterKnife.bind(this, v)
        validator.setValidationListener(this)

        return v
    }

    @OnClick(R.id.btn_confirm_phone)
    fun onConfirmPhone() {
        validator.validate()
    }

    override fun onValidationFailed(errors: MutableList<ValidationError>?) {
        for (error in errors!!) {
            val view = error.view
            val message = error.getCollatedErrorMessage(context)

            // Display error messages ;)
            if (view is EditText) {
                view.error = message
            } else {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onValidationSucceeded() {
        val phone = "${mPhone.text}"
        val action = EnterPhoneNumberDirections.actionEnterPhoneNumberToEnterOTPCode(phone)
        findNavController().navigate(action)
    }


}
