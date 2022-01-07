package com.ipe.demoapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ipe.demoapp.R
import com.ipe.demoapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
       firebaseAuth = Firebase.auth

       binding.saveDetails.setOnClickListener {
           saveDetails()
       }
    }

    private fun saveDetails() {
        firebaseAuth?.createUserWithEmailAndPassword(binding.email.text.toString(),binding.password.text.toString())
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                 val user =  firebaseAuth.currentUser
                    Log.i("Firebase User ","${user?.email}")

                }else{
                    Toast.makeText(this,"Login Failed..",Toast.LENGTH_LONG).show()
                }

            }
    }



}