package com.example.messenger.data.database

import com.example.messenger.domain.profile.UserProfile

class UserProfileMapper {

    fun mapEntityToDbModel(userProfile: UserProfile) = UserProfileDbModel(
        id = userProfile.id,
        userLogin = userProfile.userLogin,
        userFullName = userProfile.userFullName,
        userPassword = userProfile.userPassword
    )

    fun mapDbModelToEntity(userProfileDbModel: UserProfileDbModel) = UserProfile(
        id = userProfileDbModel.id,
        userLogin = userProfileDbModel.userLogin,
        userFullName = userProfileDbModel.userFullName,
        userPassword = userProfileDbModel.userPassword
    )

}