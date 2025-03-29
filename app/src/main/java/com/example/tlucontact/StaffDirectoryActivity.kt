package com.example.tlucontact

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tlucontact.adapter.StaffAdapter
import com.example.tlucontact.data.SampleData
import android.widget.Button
import com.example.tlucontact.data.Staff

class StaffDirectoryActivity : AppCompatActivity() {

    private lateinit var staffAdapter: StaffAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_directory)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rvStaff = findViewById<RecyclerView>(R.id.rvStaff)
        rvStaff.layoutManager = LinearLayoutManager(this)
        staffAdapter = StaffAdapter(SampleData.staff)
        rvStaff.adapter = staffAdapter

        staffAdapter.setOnItemClickListener { staff ->
            val intent = Intent(this, StaffDetailActivity::class.java)
            intent.putExtra("staff", staff)
            startActivityForResult(intent, STAFF_DETAIL_REQUEST_CODE)
        }

        val btnAddStaff = findViewById<Button>(R.id.btnAddStaff)
        btnAddStaff.setOnClickListener {
            val intent = Intent(this, EditStaffActivity::class.java)
            startActivityForResult(intent, ADD_STAFF_REQUEST_CODE)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish() // Close this activity and go back to the previous one
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == STAFF_DETAIL_REQUEST_CODE && resultCode == RESULT_OK) {
            staffAdapter.notifyDataSetChanged() // Refresh the adapter
        } else if (requestCode == ADD_STAFF_REQUEST_CODE && resultCode == RESULT_OK) {
            val newStaff = data?.getParcelableExtra<Staff>("newStaff")
            if (newStaff != null) {
                SampleData.addStaff(newStaff)
                staffAdapter.notifyDataSetChanged() // Refresh the adapter
            }
        }
    }

    companion object {
        private const val STAFF_DETAIL_REQUEST_CODE = 1
        private const val ADD_STAFF_REQUEST_CODE = 2
    }
}