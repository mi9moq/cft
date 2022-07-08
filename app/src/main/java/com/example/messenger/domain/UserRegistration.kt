package com.example.messenger.domain

class UserRegistration(private val messengerRepository: MessengerRepository) {

    fun userRegistration(userProfile: UserProfile){
        messengerRepository.userRegistration(userProfile)
    }
}