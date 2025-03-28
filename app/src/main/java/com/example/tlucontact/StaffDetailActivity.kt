package com.example.tlucontact

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.tlucontact.data.Staff

class StaffDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_detail)

        val staff = intent.getParcelableExtra<Staff>("staff")

        val tvStaffDetailName = findViewById<TextView>(R.id.tvStaffDetailName)
        val tvStaffDetailPosition = findViewById<TextView>(R.id.tvStaffDetailPosition)
        val tvStaffDetailPhoneNumber = findViewById<TextView>(R.id.tvStaffDetailPhoneNumber)
        val tvStaffDetailEmail = findViewById<TextView>(R.id.tvStaffDetailEmail)
        val tvStaffDetailUnit = findViewById<TextView>(R.id.tvStaffDetailUnit)

        tvStaffDetailName.text = staff?.name
        tvStaffDetailPosition.text = staff?.position
        tvStaffDetailPhoneNumber.text = staff?.phoneNumber
        tvStaffDetailEmail.text = staff?.email
        tvStaffDetailUnit.text = staff?.unit
    }
}