package com.example.wallet.presentation.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallet.R
import com.example.wallet.databinding.FragmentHomePage5Binding
import com.example.wallet.presentation.adapter.TransactionAdapter
import com.example.wallet.presentation.viewmodel.TransactionViewModel

class FragmentHomePage_5 : Fragment() {

    private lateinit var binding: FragmentHomePage5Binding
    private val transaction: TransactionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomePage5Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController(view)

        binding.recycleTransaction.layoutManager = LinearLayoutManager(context)
        binding.recycleTransaction.adapter = TransactionAdapter()
        transaction.transactionListLiveData.observe(viewLifecycleOwner) {
            transaction -> (binding.recycleTransaction.adapter as TransactionAdapter).transactions = transaction
        }

        val btnVolver = binding.txtInicio
        btnVolver.setOnClickListener{
            showConfirmationDialog(navController)
            //navController.navigate(R.id.fragmentLoginSingupPage_2)

        }

        val btnProfile = binding.imgProfile
        btnProfile.setOnClickListener{

            navController.navigate(R.id.fragmentProfilePage_9)

        }

        val btnSend = binding.btnSend
        btnSend.setOnClickListener{

            navController.navigate(R.id.fragmentSendMoney_8)

        }

        val btnRecieve= binding.btnRecieve
        btnRecieve.setOnClickListener{

            navController.navigate(R.id.fragmentRequestMoney_7)

        }


        val btnVerOcultar = binding.ImageViewNotification
        btnVerOcultar.setOnClickListener{ v: View ->

            if (binding.LayoutWithTransactions.visibility == View.VISIBLE) {
                //Log.i("hola", "hola")
                binding.layoutWhitoutTransactions.visibility = View.VISIBLE
                binding.LayoutWithTransactions.visibility = View.GONE
            } else {
               // Log.i("bye", "bye")
                binding.layoutWhitoutTransactions.visibility = View.GONE
                binding.LayoutWithTransactions.visibility = View.VISIBLE
            }
        }
    }

    private fun showConfirmationDialog(navController: NavController) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Confirmar Salir")
        builder.setMessage("¿Está seguro que desea salir?")

        builder.setPositiveButton("Si, Salir") { dialog, _ ->
            // Navigate to the desired fragment
            navController.navigate(R.id.fragmentLoginSingupPage_2)
            dialog.dismiss()
        }

        builder.setNegativeButton("No") { dialog, _ ->
            // Dismiss the dialog
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}