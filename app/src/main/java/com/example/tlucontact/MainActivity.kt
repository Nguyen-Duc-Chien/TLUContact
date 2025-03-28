package com.example.tlucontact

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnUnitDirectory = findViewById<Button>(R.id.btnUnitDirectory)
        val btnStaffDirectory = findViewById<Button>(R.id.btnStaffDirectory)

        btnUnitDirectory.setOnClickListener {
            val intent = Intent(this, UnitDirectoryActivity::class.java)
            startActivity(intent)
        }

        btnStaffDirectory.setOnClickListener {
            val intent = Intent(this, StaffDirectoryActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish() // Close this activity and go back to the previous one
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}