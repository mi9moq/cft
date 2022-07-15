package com.example.messenger.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun userRegistration(userProfileDbModel: UserProfileDbModel)

    @Query("SELECT * FROM user_profile WHERE id=:userProfileId")
    fun showUserProfile(userProfileId: Int): UserProfileDbModel


    @Query("SELECT * FROM user_profile WHERE userLogin=:login AND userPassword=:password")
     fun signIn(login: String, password: String):UserProfileDbModel?
}