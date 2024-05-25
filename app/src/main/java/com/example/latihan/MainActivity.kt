package com.example.yourapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.latihan.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity<Button> : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val currentUser = auth.currentUser
        if (currentUser == null) {
            // No user is signed in, redirect to LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        } else {
            // User is signed in, continue to main functionality
            // Here you can display user-specific information or start other activities

            findViewById<TextView>(R.id.welcomeTextView).text = "Welcome, ${currentUser.email}"

            findViewById<Button>(R.id.logoutButton).setOnClickListener {
                auth.signOut()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

}
