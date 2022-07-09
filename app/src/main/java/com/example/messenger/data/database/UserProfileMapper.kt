package com.example.messenger.data.database

import com.example.messenger.domain.UserProfile

class UserProfileMapper {

    fun mapEntityToDbModel(userProfile: UserProfile) = UserProfileDbModel(
        id = userProfile.id,
        userName = userProfile.userName,
        eMail = userProfile.eMail,
        password = userProfile.password
    )

    fun mapDbModelToEntity(userProfileDbModel: UserProfileDbModel): UserProfile {
        return UserProfile(
            id = userProfileDbModel.id,
            userName = userProfileDbModel.userName,
            eMail = userProfileDbModel.eMail,
            password = userProfileDbModel.password
        )
    }
}