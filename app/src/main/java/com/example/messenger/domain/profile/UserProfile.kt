package com.example.messenger.domain.profile

data class UserProfile(
    val userLogin: String,
    val userFullName: String,
    val userPassword: String,
    var id: Int = UNDEFINED_ID
){
    companion object{

        const val UNDEFINED_ID = 0
    }
}
