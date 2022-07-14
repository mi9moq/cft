package com.example.messenger.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.messenger.R


class LoginFragment : Fragment() {
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