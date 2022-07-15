package com.example.messenger.presentation.myprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.messenger.R
import com.example.messenger.domain.profile.UserProfile

class MyProfileFragment : Fragment() {

    private lateinit var viewModel: MyProfileViewModel

    private lateinit var tvUserLogin: TextView
    private lateinit var tvUserName: TextView

    private var userId = UserProfile.UNDEFINED_ID

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_profile,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this) [MyProfileViewModel::class.java]
        initViews(view)
        launchUserProfile()
        viewModel.userProfile.observe(viewLifecycleOwner){
            tvUserLogin.text = it.userLogin
            tvUserName.text = it.userFullName
        }
    }

    private fun initViews(view: View){
        tvUserLogin = view.findViewById(R.id.tv_user_login)
        tvUserName = view.findViewById(R.id.tv_user_name)
    }

    private fun launchUserProfile(){
        viewModel.showInfo(userId)
    }
}