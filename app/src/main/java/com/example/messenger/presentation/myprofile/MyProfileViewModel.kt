package com.example.messenger.presentation.myprofile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.messenger.data.MessengerRepositoryImpl
import com.example.messenger.domain.profile.ShowUserProfile
import com.example.messenger.domain.profile.UserProfile
import kotlinx.coroutines.launch

class MyProfileViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MessengerRepositoryImpl(application)

    private val showUserProfile = ShowUserProfile(repository)

    private val _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile>
        get() = _userProfile

    fun showInfo(userId: Int) {
        viewModelScope.launch {
            val item = showUserProfile.showUserProfile(userId)
            _userProfile.value = item
        }
    }
}