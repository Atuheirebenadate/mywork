package com.devbenadate.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView

import com.devbenadate.workout.databinding.ActivityHomeBinding
import com.devbenadate.workout.databinding.ActivityLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            validateLogin()
            startActivity(Intent(this,HomeActivity::class.java))
             finish()

        }
    }
        fun validateLogin() {
            var error = false
            var email = binding.etEmail.text.toString()
            var password = binding.etPassword.text.toString()
            if (email.isBlank()) {
                binding.tilEmail.error = "Email is required"
                error = true
            }
            if (password.isBlank()) {
                binding.tilPassword.error = "Password is required"
                error = true


            }
            if (!error) {

            }
        }
}


