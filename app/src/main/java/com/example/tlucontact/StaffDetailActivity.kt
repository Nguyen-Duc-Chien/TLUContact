package com.example.tlucontact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.tlucontact.data.Staff

class StaffDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val staff = intent.getParcelableExtra<Staff>("staff")

        val ivAvatar = findViewById<ImageView>(R.id.ivAvatar)
        val tvStaffDetailName = findViewById<TextView>(R.id.tvStaffDetailName)
        val tvStaffDetailPhoneNumber = findViewById<TextView>(R.id.tvStaffDetailPhoneNumber)
        val tvStaffDetailEmail = findViewById<TextView>(R.id.tvStaffDetailEmail)
        val tvStaffDetailPosition = findViewById<TextView>(R.id.tvStaffDetailPosition)
        val tvStaffDetailUnit = findViewById<TextView>(R.id.tvStaffDetailUnit)
        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnMessage = findViewById<Button>(R.id.btnMessage)
        val btnEmail = findViewById<Button>(R.id.btnEmail)

        // Set the avatar image (assuming avatar.jpg is in drawable folder)
        ivAvatar.setImageResource(R.drawable.avatar)

        tvStaffDetailName.text = staff?.name
        tvStaffDetailPhoneNumber.text = staff?.phoneNumber
        tvStaffDetailEmail.text = staff?.email
        tvStaffDetailPosition.text = staff?.position
        tvStaffDetailUnit.text = staff?.unit

        btnCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:${staff?.phoneNumber}")
            startActivity(callIntent)
        }

        btnMessage.setOnClickListener {
            val messageIntent = Intent(Intent.ACTION_VIEW)
            messageIntent.data = Uri.parse("sms:${staff?.phoneNumber}")
            startActivity(messageIntent)
        }

        btnEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:${staff?.email}")
            startActivity(emailIntent)
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