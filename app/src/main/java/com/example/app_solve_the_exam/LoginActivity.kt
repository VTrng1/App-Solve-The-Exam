@file:Suppress("UNUSED_PARAMETER")

package com.example.app_solve_the_exam

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var refUsers: DatabaseReference
    private var firebaseUserID: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        login_button.setOnClickListener {
            loginUser()
        }

    }

    private fun loginUser() {

        val email: String = email_login.text.toString()
        val password: String = password_login.text.toString()

        if (email == "") {
            Toast.makeText(this@LoginActivity, "Vui lòng nhập email.", Toast.LENGTH_LONG).show()
        }
        else if (password == "") {
            Toast.makeText(this@LoginActivity, "Vui lòng nhập mật khẩu.", Toast.LENGTH_LONG).show()
        }
        else {
            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Toast.makeText(this@LoginActivity, "Error Message:." + task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    fun onLoginClick(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}