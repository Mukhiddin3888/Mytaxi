package com.example.mytaxiw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_sign_up_code.view.*

class SignUpFragmentCode : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_sign_up_code, container, false)


        view.floating_action_button_code.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_signUpFragmentCode_to_signUpFragmentPassword)

        }

        return view
    }

}