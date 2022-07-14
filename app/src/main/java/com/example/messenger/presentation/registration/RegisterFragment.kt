package com.example.messenger.presentation.registration

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.messenger.R
import com.google.android.material.textfield.TextInputLayout


class RegisterFragment : Fragment() {

    private lateinit var viewModel: RegistrationViewModel

    private lateinit var tilLogin: TextInputLayout
    private lateinit var tilFullName: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var tilRePassword: TextInputLayout
    private lateinit var etLogin: EditText
    private lateinit var etFullName: EditText
    private lateinit var etPassword: EditText
    private lateinit var etRePassword: EditText
    private lateinit var btnRegister: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RegistrationViewModel::class.java]
        initViews(view)
        addTextChangeListeners()
        observeViewModel()
        createUserProfile()
    }

    private fun initViews(view: View) {
        tilLogin = view.findViewById(R.id.til_login)
        tilFullName = view.findViewById(R.id.til_full_name)
        tilPassword = view.findViewById(R.id.til_password)
        etLogin = view.findViewById(R.id.et_login)
        etFullName = view.findViewById(R.id.et_full_name)
        etPassword = view.findViewById(R.id.et_password)
        btnRegister = view.findViewById(R.id.btn_register)
    }

    private fun addTextChangeListeners() {
        etLogin.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputLogin()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        etFullName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputFullName()
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        etPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputPassword()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    private fun observeViewModel() {
        viewModel.errorInputUserLogin.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.invalid_mail)
            } else {
                null
            }
            tilLogin.error = message
        }
        viewModel.errorInputUserFullName.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.invalid_name)
            } else {
                null
            }
            tilFullName.error = message
        }
        viewModel.errorInputPassword.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.invalid_password)
            } else {
                null
            }
            tilPassword.error = message
        }
    }

    private fun createUserProfile(){
        btnRegister.setOnClickListener {
            viewModel.registration(
                etLogin.text.toString(),
                etFullName.text.toString(),
                etPassword.text.toString()
            )
        }
    }

//    private lateinit var btnreg: Button
//    private lateinit var edname: EditText
//    private lateinit var edemail: EditText
//    private lateinit var edpass: EditText
//    private lateinit var edrepass: EditText
//    private lateinit var imgGoogle: ImageButton

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val viewout = inflater.inflate(R.layout.fragment_register, container, false)
//        btnreg = viewout.findViewById(R.id.btn_register)
//        edname = viewout.findViewById(R.id.et_name)
//        edemail = viewout.findViewById(R.id.et_email)
//        edpass = viewout.findViewById(R.id.et_password)
//        edrepass = viewout.findViewById(R.id.et_repassword)
//
//
//        btnreg.setOnClickListener {
//            val email = edemail.text.toString()
//            if ((edpass.text.toString().length < 6) || ((edname.text
//                    .toString() == "")) || (!email.contains(".")) || ((edpass.text
//                    .toString() == "")) || (edrepass.text.toString() != edpass.text
//                    .toString()) || (!email.contains("@"))
//            ) {
//                if ((edname.text.toString() == "")) Toast.makeText(
//                    context,
//                    R.string.name,
//                    Toast.LENGTH_SHORT
//                ).show() else if (edpass.text.toString().length < 6) Toast.makeText(
//                    context, R.string.passshort, Toast.LENGTH_SHORT
//                )
//                    .show() else if ((!email.contains("@")) || !email.contains(".")) Toast.makeText(
//                    context, R.string.email, Toast.LENGTH_SHORT
//                ).show() else if ((edpass.text.toString() == "")) Toast.makeText(
//                    context, R.string.inppass, Toast.LENGTH_SHORT
//                ).show() else if (edrepass.text.toString() != edpass.text
//                        .toString()
//                ) Toast.makeText(
//                    context, R.string.notequalpass, Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//        return viewout
//    }

}