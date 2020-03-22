package com.minhbka.navigationcomponent


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.*
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import kotlinx.android.synthetic.main.fragment_specify_amount.cancel_btn
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment(), View.OnClickListener {
    lateinit var recipient:String
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments!!.getString("recipient")!!
    }
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

        val message = "Send money to $recipient"
        recipient_text.text = message



    }
    override fun onClick(v: View?) {
        when(v!!){
            send_btn -> {
                if (!input_amount.text.isNullOrEmpty()){
                    val amount = Money(BigDecimal(input_amount.text.toString()))
                    val bundle = bundleOf("recipient" to recipient, "amount" to amount)
                    navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle)
                }
                else{
                    Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
                }

            }

            cancel_btn -> activity!!.onBackPressed()

        }
    }
}
