package com.example.mytaxiw.signUp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.mytaxiw.HomeActivity
import com.example.mytaxiw.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_sign_up_code.view.*

class SignUpFragmentCode : Fragment() {

    lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //// Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up_code, container, false)






        view.floating_action_button_code.setOnClickListener {


        }
        return view
    }

}