package com.example.tlucontact

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.tlucontact.data.OrgUnit
import com.example.tlucontact.data.SampleData

class UnitDetailActivity : AppCompatActivity() {

    private lateinit var unit: OrgUnit
    private lateinit var tvUnitDetailName: TextView
    private lateinit var tvUnitDetailPhoneNumber: TextView
    private lateinit var tvUnitDetailAddress: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        unit = intent.getParcelableExtra("unit")!!

        val ivAvatar = findViewById<ImageView>(R.id.ivAvatar)
        tvUnitDetailName = findViewById(R.id.tvUnitDetailName)
        tvUnitDetailPhoneNumber = findViewById(R.id.tvUnitDetailPhoneNumber)
        tvUnitDetailAddress = findViewById(R.id.tvUnitDetailAddress)
        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnMessage = findViewById<Button>(R.id.btnMessage)
        val btnOpenAddress = findViewById<Button>(R.id.btnOpenAddress)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnDelete = findViewById<Button>(R.id.btnDelete)

        ivAvatar.setImageResource(R.drawable.avatar)

        tvUnitDetailName.text = unit.name
        tvUnitDetailPhoneNumber.text = unit.phoneNumber
        tvUnitDetailAddress.text = unit.address

        btnCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:${unit.phoneNumber}")
            startActivity(callIntent)
        }

        btnMessage.setOnClickListener {
            val messageIntent = Intent(Intent.ACTION_VIEW)
            messageIntent.data = Uri.parse("sms:${unit.phoneNumber}")
            startActivity(messageIntent)
        }

        btnOpenAddress.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${unit.address}"))
            startActivity(mapIntent)
        }

        btnEdit.setOnClickListener {
            val editIntent = Intent(this, EditUnitActivity::class.java)
            editIntent.putExtra("unit", unit)
            startActivityForResult(editIntent, EDIT_UNIT_REQUEST_CODE)
        }

        btnDelete.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Xóa đơn vị")
                .setMessage("Bạn có chắc chắn muốn xóa đơn vị này?")
                .setPositiveButton("Xóa") { dialog, which ->
                    SampleData.removeUnit(unit.id)
                    val resultIntent = Intent()
                    setResult(Activity.RESULT_OK, resultIntent)
                    finish()
                }
                .setNegativeButton("Hủy", null)
                .show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDIT_UNIT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val updatedUnit = data?.getParcelableExtra<OrgUnit>("updatedUnit")
            if (updatedUnit != null) {
                SampleData.updateUnit(updatedUnit)
                unit = updatedUnit
                tvUnitDetailName.text = unit.name
                tvUnitDetailPhoneNumber.text = unit.phoneNumber
                tvUnitDetailAddress.text = unit.address
                setResult(Activity.RESULT_OK) // Notify that the data has changed
            }
        }
    }

    companion object {
        private const val EDIT_UNIT_REQUEST_CODE = 1
    }
}