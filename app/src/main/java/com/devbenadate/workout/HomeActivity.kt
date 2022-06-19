package com.devbenadate.workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.devbenadate.workout.PlanFragment
import com.devbenadate.workout.ProfileFragment
import com.devbenadate.workout.R
import com.devbenadate.workout.TrackFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var fcvHome:FragmentContainerView
    lateinit var bnvHome:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        castViews()
       setupButton()
    }
    fun castViews(){
        fcvHome = findViewById(R.id.fcvHome)
        bnvHome = findViewById(R.id.bnvHome)
    }
    fun setupButton(){
        bnvHome.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.plan->{
                    val transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome,PlanFragment()).commit()
                    true
                }
                R.id.profile->{
                    val transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome,ProfileFragment()).commit()
                    true
            }
                R.id.track->{
                    val transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome,TrackFragment()).commit()
                    true
        }
                else-> false

    }
 }
    }
}