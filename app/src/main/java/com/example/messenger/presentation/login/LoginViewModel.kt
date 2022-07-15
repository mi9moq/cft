package com.example.messenger.presentation.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.messenger.data.MessengerRepositoryImpl
import com.example.messenger.domain.profile.UserProfile
import com.example.messenger.domain.profile.UserSignIn
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MessengerRepositoryImpl(application)

    private val userSignIn = UserSignIn(repository)

    private val _userProfile = MutableLiveData<UserProfile?>()
    val userProfile: LiveData<UserProfile?>
        get() = _userProfile

    private val _errorInputPassword = MutableLiveData<Boolean>()
    val errorInputPassword: LiveData<Boolean>
        get() = _errorInputPassword

    private val _errorInputUserLogin = MutableLiveData<Boolean>()
    val errorInputUserLogin: LiveData<Boolean>
        get() = _errorInputUserLogin

    fun signIn(
        inputUserName: String?,
        inputPassword: String?
    ) {
        val userName = parseInput(inputUserName)
        val userPassword = parseInput(inputPassword)
        val fieldsValid = validateInput(
            userName,
            userPassword
        )
        if(fieldsValid) {
            viewModelScope.launch {
                val user = userSignIn.userSignIn(userName, userPassword)
                if (user == null) {
                    _userProfile.value = null
                    Log.d("LoginViewModel", "такого пользователя не сущ")
                } else {
                    _userProfile.value = user
                }
            }
        }
    }

    private fun parseInput(inputString: String?): String {
        return inputString?.trim() ?: ""
    }

    private fun validateInput(
        userLogin: String,
        userPassword: String
    ): Boolean {
        var result = true
        if (userLogin.isBlank()) {
            _errorInputUserLogin.value = true
            result = false
        }
        if (userPassword.isBlank()) {
            _errorInputPassword.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputLogin() {
        _errorInputUserLogin.value = false
    }

    fun resetErrorInputPassword() {
        _errorInputPassword.value = false
    }
}