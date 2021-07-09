@file:Suppress("NAME_SHADOWING", "UNUSED_PARAMETER")

package com.example.app_solve_the_exam

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var refUsers: DatabaseReference
    private var firebaseUserID: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        register_btn.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {

        val fullname: String = fullname_register.text.toString()
        val phonenumber: String = phonenumber_register.text.toString()
        val username: String = username_register.text.toString()
        val email: String = email_register.text.toString()
        val password: String = password_register.text.toString()

        if (fullname == "") {
            Toast.makeText(this@RegisterActivity, "Vui lòng nhập họ và tên.", Toast.LENGTH_LONG).show()
        }
        else if (phonenumber == "") {
            Toast.makeText(this@RegisterActivity, "Vui lòng nhập số điện thoại.", Toast.LENGTH_LONG).show()
        }
        else if (username == "") {
            Toast.makeText(this@RegisterActivity, "Vui lòng nhập tài khoản.", Toast.LENGTH_LONG).show()
        }
        else if (email == "") {
            Toast.makeText(this@RegisterActivity, "Vui lòng nhập email.", Toast.LENGTH_LONG).show()
        }
        else if (password == "") {
            Toast.makeText(this@RegisterActivity, "Vui lòng nhập mật khẩu.", Toast.LENGTH_LONG).show()
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        firebaseUserID = mAuth.currentUser!!.uid
                        refUsers = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseUserID)

                        val userHashMap = HashMap<String, Any>()
                        userHashMap["uid"] = firebaseUserID
                        userHashMap["fullname"] = fullname
                        userHashMap["username"] = username
                        userHashMap["profile"] = "https://firebasestorage.googleapis.com/v0/b/app-solve-the-exam-3b58c.appspot.com/o/userphoto.png?alt=media&token=7562aa62-1799-4dcc-bc19-fa066bf4b032"
                        userHashMap["cover"] = "https://firebasestorage.googleapis.com/v0/b/app-solve-the-exam-3b58c.appspot.com/o/cover.jpg?alt=media&token=4267dae0-c3b2-4c70-8fd1-22c0f3cd7c0d"
                        userHashMap["status"] = "offline"
                        userHashMap["search"] = username.toLowerCase()
                        userHashMap["facebook"] = "https://m.facebook.com"
                        userHashMap["website"] = "https://www.google.com"

                        refUsers.updateChildren(userHashMap)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                                    startActivity(intent)
                                    finish()
                                }
                            }

                    }
                    else {
                        Toast.makeText(this@RegisterActivity, "Error Message:." + task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }
        }
    }


    fun onLoginClick(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}