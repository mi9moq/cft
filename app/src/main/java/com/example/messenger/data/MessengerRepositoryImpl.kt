package com.example.messenger.data

import android.app.Application
import com.example.messenger.data.database.AppDatabase
import com.example.messenger.data.database.UserProfileMapper
import com.example.messenger.domain.profile.MessengerRepository
import com.example.messenger.domain.profile.UserProfile


class MessengerRepositoryImpl(
    application: Application
) : MessengerRepository {

    private val userProfileDao = AppDatabase.getInstance(application).userProfileDao()
    private val mapper = UserProfileMapper()

    override suspend fun userRegistration(userProfile: UserProfile) {
        userProfileDao.userRegistration(mapper.mapEntityToDbModel(userProfile))
    }

    override suspend fun editUserProfile(userProfile: UserProfile) {
        userProfileDao.userRegistration(mapper.mapEntityToDbModel(userProfile))
    }

    override suspend fun showUserProfile(id: Int): UserProfile {
        val dbModel = userProfileDao.showUserProfile(id)
        return mapper.mapDbModelToEntity(dbModel)
    }


    override suspend fun signIn(userEmail: String, password: String): UserProfile? {
        val dbModel = userProfileDao.signIn(userEmail, password)
        return if (dbModel == null) {
            null
        } else {
            mapper.mapDbModelToEntity(dbModel)
        }
    }
}