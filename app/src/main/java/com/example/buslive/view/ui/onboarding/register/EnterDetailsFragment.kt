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
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword
import com.mobsandgeeks.saripaar.annotation.Email
import com.mobsandgeeks.saripaar.annotation.NotEmpty
import com.mobsandgeeks.saripaar.annotation.Password

class EnterDetailsFragment : Fragment(), Validator.ValidationListener {

    @NotEmpty(message = "Full name is required")
    @BindView(R.id.edt_full_name)
    lateinit var mFullName: AppCompatEditText

    @Email(message = "Enter a valid email address")
    @BindView(R.id.edt_email)
    lateinit var mEmail: AppCompatEditText

    @Password
    @BindView(R.id.edt_password)
    lateinit var mPassword: AppCompatEditText

    @ConfirmPassword
    @BindView(R.id.edt_confirm_password)
    lateinit var mConfirmPassword: AppCompatEditText

    private val validator: Validator by lazy { Validator(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_enter_details, container, false)
        ButterKnife.bind(this, v)
        validator.setValidationListener(this)
        return v
    }

    @OnClick(R.id.btn_confirm_details)
    fun onCompleteAccountSignUp() {
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
        findNavController().navigate(R.id.pendingScreenFragment)
    }

}
