package com.devbenadate.workout.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.devbenadate.workout.ViewModel.UserViewModel
import com.devbenadate.workout.databinding.ActivityLoginBinding
import com.devbenadate.workout.models.LoginRequest
import com.devbenadate.workout.models.LoginResponse
import com.devbenadate.workout.api.ApiClient

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var  sharedPrefs:SharedPreferences
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

        binding.tvSignup.setOnClickListener{
            var intent =Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }


        binding.btnLogin.setOnClickListener {
            validateLogin()

        }
        }
       override fun onResume() {
          super.onResume()
           userViewModel.loginResponseLiveData.observe(this, Observer { LoginResponse ->
               saveloginResponse(LoginResponse!!)
       Toast.makeText(baseContext,LoginResponse?.message,Toast.LENGTH_LONG).show()
       startActivity(Intent(baseContext,HomeActivity::class.java))
        finish()
           })
           userViewModel.loginErrorLiveDataData.observe(this, Observer { error->
               Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
           })


      }

        fun validateLogin() {

            var email = binding.etEmail.text.toString()
            var password = binding.etPassword.text.toString()
            var error=false
            if (email.isBlank()) {
                binding.tilEmail.error = "Email is required"
                error = true
            }
            if (password.isBlank()) {
                binding.tilPassword.error = "Password is required"
                error = true

            }
            if (!error) {
                binding.btnLogin.visibility=View.VISIBLE
                val loginRequest=LoginRequest(email, password)
                userViewModel.loginUser(loginRequest)
            } }



   fun saveloginResponse(loginResponse: LoginResponse){
      val editor =sharedPrefs.edit()
       val token="Bearer ${LoginResponse.accessToken}"
//     editor.putString("ACCESS_TOKEN",loginResponse.acess)
     editor.putString( "USER_ID",loginResponse.profile_id)
      editor.putString("PROFILE_ID",loginResponse.profile_id)
      editor.apply()

    }
}



