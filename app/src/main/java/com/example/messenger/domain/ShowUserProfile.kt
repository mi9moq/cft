package com.example.messenger.domain

class ShowUserProfile(private val messengerRepository: MessengerRepository) {

    fun showUserProfile(id : Int) : UserProfile{
        return messengerRepository.showUserProfile(id)
    }
}