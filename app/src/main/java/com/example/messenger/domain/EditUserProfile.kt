package com.example.messenger.domain

class EditUserProfile(private val messengerRepository: MessengerRepository) {

    fun editUserProfile(userProfile: UserProfile){
        messengerRepository.editUserProfile(userProfile)
    }
}