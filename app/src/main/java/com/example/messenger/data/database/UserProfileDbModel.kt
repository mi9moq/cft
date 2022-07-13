package com.example.messenger.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.messenger.domain.UserProfile

@Entity(tableName ="user_profile")
data class UserProfileDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userName : String,
    val eMail: String,
    val password: String
)