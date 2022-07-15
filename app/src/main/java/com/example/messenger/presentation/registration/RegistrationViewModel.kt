package com.example.messenger.presentation.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.messenger.data.MessengerRepositoryImpl
import com.example.messenger.domain.profile.UserProfile
import com.example.messenger.domain.profile.UserRegistration
import kotlinx.coroutines.launch

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MessengerRepositoryImpl(application)

    private val userRegistration = UserRegistration(repository)

    private val _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile>
        get() = _userProfile

    private val _errorInputPassword = MutableLiveData<Boolean>()
    val errorInputPassword: LiveData<Boolean>
        get() = _errorInputPassword

    private val _errorInputUserFullName = MutableLiveData<Boolean>()
    val errorInputUserFullName: LiveData<Boolean>
        get() = _errorInputUserFullName


    private val _errorInputUserLogin = MutableLiveData<Boolean>()
    val errorInputUserLogin: LiveData<Boolean>
        get() = _errorInputUserLogin


    fun registration(
        inputUserLogin: String?,
        inputUserFullName: String?,
        inputPassword: String?
    ) {
        val userLogin = parseInput(inputUserLogin)
        val userFullName = parseInput(inputUserFullName)
        val userPassword = parseInput(inputPassword)
        val fieldsValid = validateInput(
            userLogin,
            userFullName,
            userPassword
        )
        if (fieldsValid) {
            viewModelScope.launch {
                val userProfile = UserProfile(
                    userLogin = userLogin,
                    userFullName = userFullName,
                    userPassword = userPassword
                )
                userRegistration.userRegistration(userProfile)
            }
        }
    }

    private fun parseInput(inputString: String?): String {
        return inputString?.trim() ?: ""
    }

    private fun validateInput(
        userLogin: String,
        userFullName: String,
        userPassword: String
    ): Boolean {
        var result = true
        if (
            userLogin.isBlank() ||
            !userLogin.contains('@') ||
            !userLogin.contains('.') ||
            userLogin[userLogin.length - 1] == '.'
        ) {
            _errorInputUserLogin.value = true
            result = false
        }
        if (
            userFullName.isBlank() ||
            userFullName.any { it.isDigit() } ||
            Regex("[~!@#\$%^&*+_()':;?.,]").containsMatchIn(userFullName)
        ) {
            _errorInputUserFullName.value = true
            result = false
        }
        if (userPassword.isBlank()||Regex("[^A-Za-z0-9]").containsMatchIn(userPassword)) {
            _errorInputPassword.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputLogin() {
        _errorInputUserLogin.value = false
    }

    fun resetErrorInputFullName() {
        _errorInputUserFullName.value = false
    }

    fun resetErrorInputPassword() {
        _errorInputPassword.value = false
    }

}