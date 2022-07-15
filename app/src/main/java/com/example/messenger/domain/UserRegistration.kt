package com.example.messenger.domain

class UserRegistration(private val messengerRepository: MessengerRepository) {

    suspend fun userRegistration(userProfile: UserProfile){
        messengerRepository.userRegistration(userProfile)
    }
}