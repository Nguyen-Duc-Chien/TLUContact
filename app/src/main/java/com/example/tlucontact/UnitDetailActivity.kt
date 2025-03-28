package com.example.tlucontact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.tlucontact.data.OrgUnit // Đổi từ Unit -> OrgUnit

class UnitDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val unit = intent.getParcelableExtra<OrgUnit>("unit") // Đổi từ Unit -> OrgUnit

        val ivAvatar = findViewById<ImageView>(R.id.ivAvatar)
        val tvUnitDetailName = findViewById<TextView>(R.id.tvUnitDetailName)
        val tvUnitDetailPhoneNumber = findViewById<TextView>(R.id.tvUnitDetailPhoneNumber)
        val tvUnitDetailAddress = findViewById<TextView>(R.id.tvUnitDetailAddress)
        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnMessage = findViewById<Button>(R.id.btnMessage)
        val btnOpenAddress = findViewById<Button>(R.id.btnOpenAddress)

        // Set the avatar image (assuming avatar.jpg is in drawable folder)
        ivAvatar.setImageResource(R.drawable.avatar)

        tvUnitDetailName.text = unit?.name
        tvUnitDetailPhoneNumber.text = unit?.phoneNumber
        tvUnitDetailAddress.text = unit?.address

        btnCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:${unit?.phoneNumber}")
            startActivity(callIntent)
        }

        btnMessage.setOnClickListener {
            val messageIntent = Intent(Intent.ACTION_VIEW)
            messageIntent.data = Uri.parse("sms:${unit?.phoneNumber}")
            startActivity(messageIntent)
        }

        btnOpenAddress.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${unit?.address}"))
            startActivity(mapIntent)
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