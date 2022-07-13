package com.example.messenger.presentation.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.messenger.data.MessengerRepositoryImpl
import com.example.messenger.domain.UserProfile
import com.example.messenger.domain.UserRegistration
import kotlinx.coroutines.launch

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MessengerRepositoryImpl(application)

    private val userRegistration = UserRegistration(repository)

    fun registration(userProfile: UserProfile){
        viewModelScope.launch {
            userRegistration.userRegistration(userProfile)
        }
    }
}