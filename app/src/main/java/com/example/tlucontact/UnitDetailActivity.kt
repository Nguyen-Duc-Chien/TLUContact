package com.example.tlucontact

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.tlucontact.data.OrgUnit // Đổi từ Unit -> OrgUnit

class UnitDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val unit = intent.getParcelableExtra<OrgUnit>("unit") // Đổi từ Unit -> OrgUnit

        val tvUnitDetailName = findViewById<TextView>(R.id.tvUnitDetailName)
        val tvUnitDetailPhoneNumber = findViewById<TextView>(R.id.tvUnitDetailPhoneNumber)
        val tvUnitDetailAddress = findViewById<TextView>(R.id.tvUnitDetailAddress)

        tvUnitDetailName.text = unit?.name
        tvUnitDetailPhoneNumber.text = unit?.phoneNumber
        tvUnitDetailAddress.text = unit?.address
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish() // Close this activity and go back to the previous one
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
