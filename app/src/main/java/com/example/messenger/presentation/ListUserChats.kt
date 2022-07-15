package com.example.messenger.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.messenger.databinding.ListuserchatsBinding
import com.example.messenger.presentation.models.User

class ListUserChats : Fragment(), UserListener {
    private var _binding: ListuserchatsBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListuserchatsBinding.inflate(inflater, container, false)
        val view = binding.root
        getUsers()
        return view

    }


    private fun getUsers() {
        loading(true)
        //TODO получение списка пользователей из БД/Бэка
        val users: ArrayList<User> = ArrayList()
        val user1 = User("Roman", "Hello, I`m one of Android developers", "fef", "434")
        val user2 = User("NeRoman", "I`m not Android developer", "fef", "434")
        val user3 = User("Borya", "Please, give me one bottle of water", "fef", "434")
        users.add(user1)
        users.add(user2)
        users.add(user3)
        val usersAdapter = UsersAdapter(users, this)
        binding.usersRecyclerView.adapter = usersAdapter
        loading(false)


    }

    private fun loading(isLoading: Boolean) {
        if (isLoading)
            binding.usersloadbar.visibility = View.VISIBLE
        else
            binding.usersloadbar.visibility = View.INVISIBLE

    }

    override fun onUserClicked(user: User) {
        //Snackbar.make(view!!, user.name, Snackbar.LENGTH_SHORT).show()

        //TODO Заменить текущий фрагмент на диалог
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}