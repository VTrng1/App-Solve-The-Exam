@file:Suppress("UNUSED_PARAMETER")

package com.example.app_solve_the_exam

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class BlogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)
    }

    fun onClickMain(view: View) {
        val intent = Intent(this@BlogActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}