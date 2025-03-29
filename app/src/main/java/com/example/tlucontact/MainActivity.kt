package com.example.tlucontact

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivLogo = findViewById<ImageView>(R.id.ivLogo)
        val btnUnitDirectory = findViewById<Button>(R.id.btnUnitDirectory)
        val btnStaffDirectory = findViewById<Button>(R.id.btnStaffDirectory)
        val logoutButton: Button = findViewById(R.id.btnLogOut)


        btnUnitDirectory.setOnClickListener {
            val intent = Intent(this, UnitDirectoryActivity::class.java)
            startActivity(intent)
        }

        btnStaffDirectory.setOnClickListener {
            val intent = Intent(this, StaffDirectoryActivity::class.java)
            startActivity(intent)
        }

        logoutButton.setOnClickListener {
            // Navigate back to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Close the MainActivity
        }
    }

}