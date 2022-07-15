package com.example.messenger.presentation.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.messenger.data.MessengerRepositoryImpl
import com.example.messenger.domain.profile.UserSignIn
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MessengerRepositoryImpl(application)

    private val userSignIn = UserSignIn(repository)

    fun signIn(
        inputUserName: String?,
        inputPassword: String?
    ) {
        val userName = parseInput(inputUserName)
        val userPassword = parseInput(inputPassword)
        viewModelScope.launch {
            val userProfile = userSignIn.userSignIn(userName, userPassword)
            if (userProfile == null) {
                Log.d("LoginViewModel", "такого пользователя не сущ")
            } else {
                Log.d("LoginViewModel", userProfile.userFullName)
            }
        }

    }

    private fun parseInput(inputString: String?): String {
        return inputString?.trim() ?: ""
    }

}