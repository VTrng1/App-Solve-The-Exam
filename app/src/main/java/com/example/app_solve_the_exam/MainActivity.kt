@file:Suppress("UNUSED_PARAMETER")

package com.example.app_solve_the_exam

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_signOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }



    }

    fun onClickBlog(view: View) {
        val intent = Intent(this@MainActivity, BlogActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun onClickMinigame(view: View) {
        val intent = Intent(this@MainActivity, MinigameActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun onClickQA(view: View) {
        val intent = Intent(this@MainActivity, QaActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun onClickIntroduce(view: View) {
        val intent = Intent(this@MainActivity, IntroduceActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun onClickDocument(view: View) {
        val intent = Intent(this@MainActivity, DocumentActivity::class.java)
        startActivity(intent)
        finish()
    }
}
