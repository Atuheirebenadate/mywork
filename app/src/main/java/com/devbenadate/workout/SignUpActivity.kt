package com.devbenadate.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.devbenadate.workout.databinding.ActivityLoginBinding
import com.devbenadate.workout.databinding.ActivitySignUpBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
   lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

     binding.tvLogin.setOnClickListener {
            var intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }


     binding.btnSignup.setOnClickListener {
            validateLogin()
        }
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
        if(!error){
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
}