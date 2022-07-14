package com.example.messenger.presentation.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.messenger.data.MessengerRepositoryImpl
import com.example.messenger.domain.profile.UserSignIn

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MessengerRepositoryImpl(application)

    private val userRegistration = UserSignIn(repository)

    fun signIn(
        inputUserName: String?,
        inputPassword: String?
    ) {

    }

    private fun parseInput(inputString: String?): String {
        return inputString?.trim() ?: ""
    }
}