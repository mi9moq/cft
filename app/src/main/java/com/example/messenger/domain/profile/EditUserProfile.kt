package com.example.messenger.domain.profile

class EditUserProfile(private val messengerRepository: MessengerRepository) {

    suspend fun editUserProfile(userProfile: UserProfile){
        messengerRepository.editUserProfile(userProfile)
    }
}