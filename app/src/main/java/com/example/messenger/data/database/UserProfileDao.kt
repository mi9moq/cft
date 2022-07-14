package com.example.messenger.data.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface UserProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun userRegistration(userProfileDbModel: UserProfileDbModel)

    @Query("SELECT * FROM user_profile WHERE id=:userProfileId")
    suspend fun showUserProfile(userProfileId: Int): UserProfileDbModel

    @Query("SELECT * FROM user_profile WHERE userName=:login AND userPassword=:password")
    suspend fun signIn(login: String, password: String):UserProfileDbModel?
}