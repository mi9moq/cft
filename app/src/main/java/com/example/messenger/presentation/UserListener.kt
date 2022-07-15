package com.example.messenger.presentation

import com.example.messenger.presentation.models.User

public interface UserListener {
    fun onUserClicked(user: User)
}