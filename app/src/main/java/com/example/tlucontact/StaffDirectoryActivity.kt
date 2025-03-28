package com.example.tlucontact

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tlucontact.adapter.StaffAdapter
import com.example.tlucontact.data.SampleData

class StaffDirectoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_directory)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rvStaff = findViewById<RecyclerView>(R.id.rvStaff)
        rvStaff.layoutManager = LinearLayoutManager(this)
        val staffAdapter = StaffAdapter(SampleData.staff)
        rvStaff.adapter = staffAdapter

        staffAdapter.setOnItemClickListener { staff ->
            val intent = Intent(this, StaffDetailActivity::class.java)
            intent.putExtra("staff", staff)
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