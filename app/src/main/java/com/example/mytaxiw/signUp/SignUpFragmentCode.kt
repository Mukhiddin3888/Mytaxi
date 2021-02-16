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




        var code = view.lnl_entercode.text.toString()

        auth = FirebaseAuth.getInstance()



        var storedVerificationId =  arguments?.getString("code")


        var pnumber =  arguments?.getString("phoneNumber")


       view.txv_phone_num_in_code.text = pnumber

        view.floating_action_button_code.setOnClickListener {



            var otp=code.trim()
            if(!otp.isEmpty()){
                val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                        storedVerificationId.toString(), otp)
                signInWithPhoneAuthCredential(credential)
            }else{
                Toast.makeText(this.requireContext(),"Enter OTP",Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this.requireActivity()) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(activity, HomeActivity::class.java)
                    activity?.startActivity(intent)
                    activity?.finish()

                } else {
// Sign in failed, display a message and update the UI
                    Toast.makeText(this.requireContext(), "sign in failed", Toast.LENGTH_SHORT).show()
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
// The verification code entered was invalid
                        Toast.makeText(this.requireContext(), "Invalid OTP", Toast.LENGTH_SHORT).show()
                    }

                }
            }
    }

}