@file:Suppress("UNUSED_PARAMETER")

package com.example.app_solve_the_exam

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MinigameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minigame)
    }

    fun onClickMain(view: View) {
        val intent = Intent(this@MinigameActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}