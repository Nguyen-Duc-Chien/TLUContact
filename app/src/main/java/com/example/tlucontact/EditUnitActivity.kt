package com.example.tlucontact

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tlucontact.data.OrgUnit

class EditUnitActivity : AppCompatActivity() {

    private lateinit var etUnitName: EditText
    private lateinit var etUnitPhoneNumber: EditText
    private lateinit var etUnitAddress: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_unit)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val unit = intent.getParcelableExtra<OrgUnit>("unit")

        etUnitName = findViewById(R.id.etUnitName)
        etUnitPhoneNumber = findViewById(R.id.etUnitPhoneNumber)
        etUnitAddress = findViewById(R.id.etUnitAddress)
        btnSave = findViewById(R.id.btnSave)

        etUnitName.setText(unit?.name)
        etUnitPhoneNumber.setText(unit?.phoneNumber)
        etUnitAddress.setText(unit?.address)

        btnSave.setOnClickListener {
            val updatedUnit = OrgUnit(
                unit?.id ?: 0,
                etUnitName.text.toString(),
                etUnitPhoneNumber.text.toString(),
                etUnitAddress.text.toString()
            )
            val resultIntent = Intent()
            resultIntent.putExtra("updatedUnit", updatedUnit)
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