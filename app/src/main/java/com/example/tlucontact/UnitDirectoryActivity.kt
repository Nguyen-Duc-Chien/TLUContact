package com.example.tlucontact

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tlucontact.adapter.UnitAdapter
import com.example.tlucontact.data.OrgUnit
import com.example.tlucontact.data.SampleData

class UnitDirectoryActivity : AppCompatActivity() {

    private lateinit var unitAdapter: UnitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_directory)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rvUnits = findViewById<RecyclerView>(R.id.rvUnits)
        rvUnits.layoutManager = LinearLayoutManager(this)
        unitAdapter = UnitAdapter(SampleData.units)
        rvUnits.adapter = unitAdapter

        val etSearch = findViewById<EditText>(R.id.etSearch)
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                unitAdapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        unitAdapter.setOnItemClickListener { unit ->
            val intent = Intent(this, UnitDetailActivity::class.java)
            intent.putExtra("unit", unit)
            startActivityForResult(intent, UNIT_DETAIL_REQUEST_CODE)
        }

        val btnAddUnit = findViewById<Button>(R.id.btnAddUnit)
        btnAddUnit.setOnClickListener {
            val intent = Intent(this, EditUnitActivity::class.java)
            startActivityForResult(intent, ADD_UNIT_REQUEST_CODE)
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
        if (requestCode == UNIT_DETAIL_REQUEST_CODE && resultCode == RESULT_OK) {
            unitAdapter.notifyDataSetChanged() // Refresh the adapter
        } else if (requestCode == ADD_UNIT_REQUEST_CODE && resultCode == RESULT_OK) {
            val newUnit = data?.getParcelableExtra<OrgUnit>("newUnit")
            if (newUnit != null) {
                SampleData.addUnit(newUnit)
                unitAdapter.notifyDataSetChanged() // Refresh the adapter
            }
        }
    }

    companion object {
        private const val UNIT_DETAIL_REQUEST_CODE = 1
        private const val ADD_UNIT_REQUEST_CODE = 2
    }
}