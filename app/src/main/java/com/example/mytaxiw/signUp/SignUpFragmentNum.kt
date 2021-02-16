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

    lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks


    lateinit var number:String

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up_num, container, false)

        auth = FirebaseAuth.getInstance()

        var currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }


        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                val intent = Intent(activity, HomeActivity::class.java)
                activity?.startActivity(intent)
                activity?.finish()

            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken

            ) {

                Log.d("TAG", "onCodeSent:$verificationId")
                storedVerificationId = verificationId
                resendToken = token

                val bundle = bundleOf("code" to storedVerificationId)
                view.findNavController().navigate(R.id.action_signUpFragmentNum_to_signUpFragmentCode, bundle)

               /* val bundle = Bundle()

                val fragment: Fragment = SignUpFragmentCode()
                fragment.arguments.apply {
                    bundle.putString("code", storedVerificationId)
                    bundle.putString("phoneNumber", number)

                }

                Navigation.findNavController(view).navigate(R.id.action_signUpFragmentNum_to_signUpFragmentCode)
*/
            }
        }


        view.floating_action_button.setOnClickListener {

            login()
        }


        return view
    }

    fun login() {
        val mobileNumber = view?.edt_numberUP?.text.toString().trim()
         number = "+998" + mobileNumber

        if (number.isNotEmpty()) {

            sendVerificationcode(number)
        } else {
            Toast.makeText(this.requireContext(), "Enter mobile number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendVerificationcode(number: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(number) // Phone number to verify
                .setTimeout(120L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(this.requireActivity()) // Activity (for callback binding)
                .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
                .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

}