package com.example.app_solve_the_exam

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log


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
                R.id.navigationHome -> setCurrentFragment(homeActivity)
                R.id.navigationMyProfile -> setCurrentFragment(profileActivity)
                R.id.navigationMenu -> setCurrentFragment(menuActivity)
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.btn_signOut) {
            logOut()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    private fun logOut() {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }


    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }

}
