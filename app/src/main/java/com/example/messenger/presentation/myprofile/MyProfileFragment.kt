package com.example.messenger.presentation.myprofile

import androidx.fragment.app.Fragment
import com.example.messenger.databinding.MyProfileFragmentBinding

class MyProfileFragment : Fragment() {

    private val _binding: MyProfileFragmentBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }
}