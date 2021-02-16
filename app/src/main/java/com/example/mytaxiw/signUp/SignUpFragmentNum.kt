package com.example.mytaxiw.signUp

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.mytaxiw.HomeActivity
import com.example.mytaxiw.R
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.fragment_sign_up_num.view.*
import java.util.concurrent.TimeUnit


class SignUpFragmentNum : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up_num, container, false)





        view.floating_action_button.setOnClickListener {


        }


        return view
    }




}