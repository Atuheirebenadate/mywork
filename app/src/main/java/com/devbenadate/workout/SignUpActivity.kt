package com.devbenadate.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var etFirstName: TextInputEditText
    lateinit var etLastName: TextInputEditText
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var etConfirmpassword: TextInputEditText
    lateinit var tilFirstName: TextInputLayout
    lateinit var tilLastName: TextInputLayout
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var tilConfirmpassword: TextInputLayout
    lateinit var btnSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmpassword = findViewById(R.id.etConfirmpassword)
        tilFirstName = findViewById(R.id.tilFirstName)
        tilLastName = findViewById(R.id.tilLastName)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        tilConfirmpassword = findViewById(R.id.tilConfirmpassword)
        btnSignup = findViewById(R.id.btnSignup)


        btnSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            validateLogin()
        }
    }

    fun validateLogin() {
        var email = etEmail.text.toString()
        var password = etPassword.text.toString()
        var firstname = etFirstName.text.toString()
        var lastname = etLastName.text.toString()
        var confirm = etConfirmpassword.text.toString()
        if (email.isBlank()) {
            tilEmail.error = "Email is required"
        }
        if (password.isBlank()) {
            tilPassword.error = "Password is required"
        }
        if (confirm.isBlank()) {
            tilConfirmpassword.error = "Confirm Your Password"
        }
        if (firstname.isBlank()) {
            tilFirstName.error = "Enter First Name"
        }
        if (lastname.isBlank()) {
            tilLastName.error = "Enter Last Name"
        }
    }
}