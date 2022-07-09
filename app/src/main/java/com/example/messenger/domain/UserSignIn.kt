package com.example.messenger.domain

class UserSignIn(private val messengerRepository: MessengerRepository) {

    suspend fun userSignIn(userEmail: String, password: String): UserProfile? {
        return messengerRepository.signIn(userEmail, password)
    }
}