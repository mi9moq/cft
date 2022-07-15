package com.example.messenger.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.messenger.R
import com.example.messenger.presentation.MAIN
import com.example.messenger.presentation.registration.RegisterFragment


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
        return inflater.inflate(R.layout.fragment_login,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        initViews(view)
        login()
        btnRegister.setOnClickListener {
            MAIN.navController.navigate(R.id.show_register_fragment)
        }
    }

    private fun initViews(view: View){
        btnLogin = view.findViewById(R.id.btn_login)
        btnRegister = view.findViewById(R.id.btn_register)
        etEmail = view.findViewById(R.id.et_email)
        etPassword = view.findViewById(R.id.et_password)
    }

    private fun login(){
        btnLogin.setOnClickListener {
            viewModel.signIn(
                etEmail.text.toString(),
                etPassword.text.toString()
            )
        }
    }


    companion object{
        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val EXTRA_USER_ID = "extra_user_id"
        private const val MODE_REGISTER = "mode_register"
        private const val MODE_SIGN_IN = "mode_sign_in"

        fun newIntentRegisterUser(context: Context): Intent{
            val intent = Intent(context,RegisterFragment::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE,MODE_REGISTER)
            return intent
        }
    }

//    private lateinit var btnlog: Button
//    private lateinit var edemail: EditText
//    private lateinit var edpass: EditText
//    private lateinit var forgot: TextView
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val viewout = inflater.inflate(R.layout.fragment_login, container, false)
//        btnlog = viewout.findViewById(R.id.btn_login)
//        edemail = viewout.findViewById(R.id.et_email)
//        edpass = viewout.findViewById(R.id.et_password)
//        forgot = viewout.findViewById(R.id.forgot)
//
//        btnlog.setOnClickListener {
//            val email = edemail.text.toString()
//            if (!email.contains(".") || edpass.text.toString() == "" || !email.contains("@")) {
//                if (!email.contains("@") || !email.contains(".")) Toast.makeText(
//                    context,
//                    R.string.email,
//                    Toast.LENGTH_SHORT
//                ).show() else Toast.makeText(
//                    context, R.string.inppass, Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//        return viewout
//    }
//

}