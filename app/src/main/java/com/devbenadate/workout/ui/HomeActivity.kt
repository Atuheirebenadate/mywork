package com.devbenadate.workout.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.devbenadate.workout.R
import com.devbenadate.workout.databinding.ActivityHomeBinding
import com.devbenadate.workout.databinding.ActivityLoginBinding
import com.devbenadate.workout.databinding.ActivitySignUpBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPrefs:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
       setupButton()
        binding.tvLogout.setOnClickListener{
        sharedPrefs=getSharedPreferences("WORKOUT_PREFS", MODE_PRIVATE)
         val editor=sharedPrefs.edit()
         editor.putString("ACCESS_TOKEN","")
         editor.putString("USER_ID","")
         editor.putString("PROFILE_ID","")
         editor.apply()
         startActivity(Intent(this,LoginActivity::class.java))

        }
    }
//    fun castViews(){
//        fcvHome = findViewById(R.id.fcvHome)
//        bnvHome = findViewById(R.id.bnvHome)
//    }
    fun setupButton(){

        binding.bnvHome.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.plan->{
                    val transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, PlanFragment()).commit()
                    true
                }
                R.id.profile->{
                    val transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
            }
                R.id.track->{
                    val transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, TrackFragment()).commit()
                    true
        }
                else-> false

    }
 }
    }
}