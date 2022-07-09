package com.example.messenger.domain

data class UserProfile(
    val userName : String,
    val eMail: String,
    val password: String,
    var id: Int = UNDEFINED_ID
){
    companion object{

        const val UNDEFINED_ID = 0
    }
}
