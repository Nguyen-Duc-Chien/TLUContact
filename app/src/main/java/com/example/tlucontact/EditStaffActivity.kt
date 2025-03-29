package com.example.tlucontact

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tlucontact.data.Staff

class EditStaffActivity : AppCompatActivity() {

    private lateinit var etStaffName: EditText
    private lateinit var etStaffPosition: EditText
    private lateinit var etStaffPhoneNumber: EditText
    private lateinit var etStaffEmail: EditText
    private lateinit var etStaffDepartment: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_staff)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val staff = intent.getParcelableExtra<Staff>("staff")

        etStaffName = findViewById(R.id.etStaffName)
        etStaffPosition = findViewById(R.id.etStaffPosition)
        etStaffPhoneNumber = findViewById(R.id.etStaffPhoneNumber)
        etStaffEmail = findViewById(R.id.etStaffEmail)
        etStaffDepartment = findViewById(R.id.etStaffDepartment)
        btnSave = findViewById(R.id.btnSave)

        etStaffName.setText(staff?.name)
        etStaffPosition.setText(staff?.position)
        etStaffPhoneNumber.setText(staff?.phoneNumber)
        etStaffEmail.setText(staff?.email)
        etStaffDepartment.setText(staff?.department)

        btnSave.setOnClickListener {
            val newStaff = Staff(
                staff?.id ?: 0,
                etStaffName.text.toString(),
                etStaffPosition.text.toString(),
                etStaffPhoneNumber.text.toString(),
                etStaffEmail.text.toString(),
                etStaffDepartment.text.toString()
            )
            val resultIntent = Intent()
            resultIntent.putExtra("newStaff", newStaff)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}