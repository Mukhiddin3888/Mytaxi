package com.example.mytaxiw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main_sign.view.*

class MainSignFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_main_sign, container, false)

        view.btn_sign_up.setOnClickListener{

            Navigation.findNavController(view).navigate(R.id.action_mainSignFragment_to_signUpFragmentNum)

        }


        return view
    }



}