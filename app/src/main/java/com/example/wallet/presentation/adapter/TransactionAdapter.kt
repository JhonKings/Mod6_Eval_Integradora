package com.example.wallet.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.wallet.R
import com.example.wallet.data.Transactions

class TransactionAdapter: RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    var transactions = mutableListOf<Transactions>()
    @SuppressLint("NotifyDataSetChanged")
    set(value){
        field = value
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_trasaction_recycle, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionAdapter.ViewHolder, position: Int) {
        val transaction = transactions[position]

        holder.userPhoto.setImageResource(transaction.userPhoto)
        holder.simbolArrow.setImageResource(transaction.simbolArrow)
        holder.userName.text = transaction.userName
        holder.date.text = transaction.date
        holder.amount.text = transaction.amount
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val userPhoto: ImageView = itemView.findViewById(R.id.imageViewPhoto)
        val simbolArrow: ImageView = itemView.findViewById(R.id.imageViewArrow)
        val userName: TextView = itemView.findViewById(R.id.textViewName)
        val date: TextView = itemView.findViewById(R.id.textViewDate)
        val amount: TextView = itemView.findViewById(R.id.textViewAmount)

    }

}