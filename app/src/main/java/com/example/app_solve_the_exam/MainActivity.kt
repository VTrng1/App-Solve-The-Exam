package com.example.app_solve_the_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeActivity = HomeActivity()
        val profileActivity = ProfileActivity()
        val menuActivity = MenuActivity()

        setCurrentFragment(menuActivity)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigationHome->setCurrentFragment(homeActivity)
                R.id.navigationMyProfile->setCurrentFragment(profileActivity)
                R.id.navigationMenu->setCurrentFragment(menuActivity)
            }
            true
        }
    }


    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}
