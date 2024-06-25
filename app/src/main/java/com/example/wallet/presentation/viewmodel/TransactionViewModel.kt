package com.example.wallet.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.R
import com.example.wallet.data.Transactions

class TransactionViewModel: ViewModel() {

    private var transactionList = MutableLiveData<MutableList<Transactions>>()
    val transactionListLiveData: LiveData<MutableList<Transactions>>
    get() = transactionList

    init {
        fetchTransactions()
    }

    private fun fetchTransactions() {

        var transactions = mutableListOf<Transactions>(

            Transactions(R.drawable.profile_picture_2, R.drawable.arrow_up_small, "Lunita", "10/12/2012", "+$30.0"),
            Transactions(R.drawable.profile_picture_2, R.drawable.arrow_up_small, "Morango", "13/12/2012", "+$30.0"),
            Transactions(R.drawable.profile_picture_2, R.drawable.arrow_down, "Morango", "14/12/2012", "-$20.0"),
            Transactions(R.drawable.profile_picture_2, R.drawable.arrow_down, "Pedrito", "15/12/2012", "-$10.0")

        )
        transactionList.value = transactions

    }

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