package com.example.messenger.presentation.registration

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.messenger.R
import com.example.messenger.presentation.MAIN
import com.google.android.material.textfield.TextInputLayout


class RegisterFragment : Fragment() {

    private lateinit var viewModel: RegistrationViewModel

    private lateinit var tilLogin: TextInputLayout
    private lateinit var tilFullName: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var etLogin: EditText
    private lateinit var etFullName: EditText
    private lateinit var etPassword: EditText
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
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            MAIN.navController.popBackStack(R.id.loginFragment, false)
        }
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

    private fun createUserProfile() {
        btnRegister.setOnClickListener {
            viewModel.registration(
                etLogin.text.toString(),
                etFullName.text.toString(),
                etPassword.text.toString()
            )
            MAIN.navController.navigate(R.id.myProfileFragment)
        }
    }

}