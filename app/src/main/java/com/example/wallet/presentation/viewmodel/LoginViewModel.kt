package com.example.wallet.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.data.local.Users

class LoginViewModel: ViewModel() {

    private var userListItems = MutableLiveData<MutableList<Users>>()
        //get() = userListItems

   /* init {
        fetchUsers()
    }*/

   /* private fun fetchUsers() {
        var users = mutableListOf<Users>(
            Users("1", "123"),
            Users("2", "123"),
            Users("3", "123")
        )
        userListItems.value = users
    }*/

    /*fun usersValidate(userId: String, password: String): Boolean {
        val users = userListItems.value
        if (users != null) {
            for (user in users) {
                if (user.idUser == userId && user.pass == password) {
                    return true
                }
            }
        }
        return false
    }*/

}