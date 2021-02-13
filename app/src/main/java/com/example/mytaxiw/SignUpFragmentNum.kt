package com.example.mytaxiw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_sign_up_num.view.*


class SignUpFragmentNum : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_sign_up_num, container, false)

        view.floating_action_button.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_signUpFragmentNum_to_signUpFragmentCode)
        }

        return view
    }


}