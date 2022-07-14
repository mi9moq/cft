package com.example.messenger.domain.profile

interface MessengerRepository {

    suspend fun userRegistration(userProfile: UserProfile)

    suspend fun editUserProfile(userProfile: UserProfile)

    suspend fun showUserProfile(id : Int) : UserProfile

    suspend fun signIn(userEmail: String, password: String): UserProfile?
}