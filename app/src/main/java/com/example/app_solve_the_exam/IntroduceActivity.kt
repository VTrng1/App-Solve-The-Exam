@file:Suppress("UNUSED_PARAMETER")

package com.example.app_solve_the_exam

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class IntroduceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduce)
    }

    fun onClickMain(view: View) {
        val intent = Intent(this@IntroduceActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}