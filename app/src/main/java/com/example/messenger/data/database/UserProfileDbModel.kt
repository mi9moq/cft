package com.example.messenger.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfileDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userLogin: String,
    val userFullName: String,
    val userPassword: String
)