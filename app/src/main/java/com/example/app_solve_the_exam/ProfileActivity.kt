package com.example.app_solve_the_exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : Fragment(R.layout.activity_profile) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        btn_signOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            R.layout.activity_login
        }
        return inflater.inflate(R.layout.activity_profile, container, false)
    }
}