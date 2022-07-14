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
        viewModelScope.launch {
            val userProfile = UserProfile(
                userLogin = userLogin,
                userFullName = userFullName,
                userPassword = userPassword
            )
            userRegistration.userRegistration(userProfile)
        }
    }

    private fun parseInput(inputString: String?): String {
        return inputString?.trim() ?: ""
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