package com.example.messenger.domain

class ShowUserProfile(private val messengerRepository: MessengerRepository) {

    suspend fun showUserProfile(id : Int) : UserProfile{
        return messengerRepository.showUserProfile(id)
    }
}