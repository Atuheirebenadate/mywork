package com.devbenadate.workout.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.devbenadate.workout.ViewModel.UserViewModel
import com.devbenadate.workout.api.ApiClient
import com.devbenadate.workout.databinding.ActivitySignUpBinding
import com.devbenadate.workout.api.ApiInterface
import com.devbenadate.workout.models.RegisterRequest
import com.devbenadate.workout.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
   lateinit var binding: ActivitySignUpBinding
//    lateinit var  sharedPrefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

     binding.tvLogin.setOnClickListener {
            var intent=Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


     binding.btnSignup.setOnClickListener {
            validateLogin()
        }
    }
    override fun onResume(){
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer { registerResponse ->

            Toast.makeText(baseContext,registerResponse?.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,HomeActivity::class.java))
        })
        userViewModel.registerErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }

    fun validateLogin() {
        var email =binding.etEmail.text.toString()
        var password =binding.etPassword.text.toString()
        var firstname = binding.etFirstName.text.toString()
        var lastname = binding.etLastName.text.toString()
        var confirm = binding.etConfirmpassword.text.toString()
        var error=false
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error=true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error=true
        }
        if (confirm.isBlank()) {
            binding.tilConfirmpassword.error = "Confirm Your Password"
            error=true
        }
        if (firstname.isBlank()) {
            binding.tilFirstName.error = "Enter First Name"
            error=true
        }
        if (lastname.isBlank()) {
            binding.tilLastName.error = "Enter Last Name"
            error=true
        }

       if(!error ){
           val registerRequest=RegisterRequest(firstname,lastname,email,password)
           userViewModel.registerUser(registerRequest)
        }

  }



            }



