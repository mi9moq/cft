package com.example.messenger.presentation.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.messenger.R


class RegisterFragment : Fragment() {
    private lateinit var btnreg: Button
    private lateinit var edname: EditText
    private lateinit var edemail: EditText
    private lateinit var edpass: EditText
    private lateinit var edrepass: EditText
    private lateinit var imgGoogle: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewout = inflater.inflate(R.layout.fragment_register, container, false)
        btnreg = viewout.findViewById(R.id.btn_register)
        edname = viewout.findViewById(R.id.et_name)
        edemail = viewout.findViewById(R.id.et_email)
        edpass = viewout.findViewById(R.id.et_password)
        edrepass = viewout.findViewById(R.id.et_repassword)


        btnreg.setOnClickListener {
            val email = edemail.text.toString()
            if ((edpass.text.toString().length < 6) || ((edname.text
                    .toString() == "")) || (!email.contains(".")) || ((edpass.text
                    .toString() == "")) || (edrepass.text.toString() != edpass.text
                    .toString()) || (!email.contains("@"))
            ) {
                if ((edname.text.toString() == "")) Toast.makeText(
                    context,
                    R.string.name,
                    Toast.LENGTH_SHORT
                ).show() else if (edpass.text.toString().length < 6) Toast.makeText(
                    context, R.string.passshort, Toast.LENGTH_SHORT
                )
                    .show() else if ((!email.contains("@")) || !email.contains(".")) Toast.makeText(
                    context, R.string.email, Toast.LENGTH_SHORT
                ).show() else if ((edpass.text.toString() == "")) Toast.makeText(
                    context, R.string.inppass, Toast.LENGTH_SHORT
                ).show() else if (edrepass.text.toString() != edpass.text
                        .toString()
                ) Toast.makeText(
                    context, R.string.notequalpass, Toast.LENGTH_SHORT
                ).show()
            }
        }
        return viewout
    }

}