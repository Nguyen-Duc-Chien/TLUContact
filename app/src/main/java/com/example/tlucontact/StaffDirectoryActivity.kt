package com.example.tlucontact

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tlucontact.adapter.StaffAdapter
import com.example.tlucontact.data.SampleData

class StaffDirectoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_directory)

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
}