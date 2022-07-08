package com.example.messenger.domain

interface MessengerRepository {

    fun userRegistration(userProfile: UserProfile)

    fun editUserProfile(userProfile: UserProfile)

    fun showUserProfile(id : Int) : UserProfile
}