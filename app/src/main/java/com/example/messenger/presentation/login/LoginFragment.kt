package com.example.messenger.presentation.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.messenger.R
import com.example.messenger.presentation.MAIN
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var tilLogin: TextInputLayout
    private lateinit var tilPassword: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        initViews(view)
        observeViewModel()
        addTextChangeListeners()
        login()
        viewModel.userProfile.observe(viewLifecycleOwner){
            if (it==null){
                Toast.makeText(activity,"Неверный логин или пароль",Toast.LENGTH_LONG).show()
            }
        }
        btnRegister.setOnClickListener {
            MAIN.navController.navigate(R.id.show_register_fragment)
        }
    }

    private fun initViews(view: View) {
        btnLogin = view.findViewById(R.id.btn_login)
        btnRegister = view.findViewById(R.id.btn_register)
        etEmail = view.findViewById(R.id.et_email)
        etPassword = view.findViewById(R.id.et_password)
        tilLogin = view.findViewById(R.id.til_email)
        tilPassword = view.findViewById(R.id.til_password)
    }

    private fun observeViewModel() {
        viewModel.errorInputUserLogin.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.empty_input)
            } else {
                null
            }
            tilLogin.error = message
        }
        viewModel.errorInputPassword.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.empty_input)
            } else {
                null
            }
            tilPassword.error = message
        }
    }

    private fun addTextChangeListeners() {
        etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputLogin()
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

    private fun login() {
        btnLogin.setOnClickListener {
            viewModel.signIn(
                etEmail.text.toString(),
                etPassword.text.toString()
            )
        }
    }
}