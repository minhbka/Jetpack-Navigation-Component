package com.minhbka.navigationcomponent


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_specify_amount.*


class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        send_btn.setOnClickListener(this)
        cancel_btn.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v!!){
            send_btn -> {
                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment)
            }

            cancel_btn -> activity!!.onBackPressed()

        }
    }
}
