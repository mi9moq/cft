package com.example.messenger.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.messenger.R
import com.example.messenger.presentation.MAIN


class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

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
        login()
        btnRegister.setOnClickListener {
            it.findNavController().navigate(R.id.show_register_fragment)
        }
    }

    private fun initViews(view: View) {
        btnLogin = view.findViewById(R.id.btn_login)
        btnRegister = view.findViewById(R.id.btn_register)
        etEmail = view.findViewById(R.id.et_email)
        etPassword = view.findViewById(R.id.et_password)
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