package com.devbenadate.workout.ui

import android.content.Intent
import android.content.SharedPreferences
import android.media.session.MediaSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.Observer
import com.devbenadate.workout.R
import com.devbenadate.workout.Utilities.Constants
import com.devbenadate.workout.ViewModel.ExerciseViewModel
import com.devbenadate.workout.databinding.ActivityHomeBinding
import com.devbenadate.workout.databinding.ActivityLoginBinding
import com.devbenadate.workout.databinding.ActivitySignUpBinding
import com.devbenadate.workout.exerciseCategory
import com.google.android.material.bottomnavigation.BottomNavigationView
import okio.Utf8.size

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPrefs:SharedPreferences
    val exerciseViewModel:ExerciseViewModel by viewModels()
    lateinit var sharedPreferences: SharedPreferences


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
            sharedPrefs=getSharedPreferences(Constants.prefsFile, MODE_PRIVATE)
            val token =sharedPrefs.getString(Constants.accessaToken,Constants.emptyString)
            exerciseViewModel.fetchExerciseCategories(token!!)

//         startActivity(Intent(this,LoginActivity::class.java))


        }
    }
        override fun onResume(){
            super.onResume()
            exerciseViewModel.exerciseCategoryLiveData.observe(this, Observer {
                Toast.makeText(baseContext,"fetch $ {exerciseViewModel.size} categories",Toast.LENGTH_LONG).show()

            })
        }


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