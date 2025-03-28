package com.example.tlucontact

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tlucontact.adapter.UnitAdapter
import com.example.tlucontact.data.SampleData

class UnitDirectoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_directory)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rvUnits = findViewById<RecyclerView>(R.id.rvUnits)
        rvUnits.layoutManager = LinearLayoutManager(this)
        val unitAdapter = UnitAdapter(SampleData.units)
        rvUnits.adapter = unitAdapter

        unitAdapter.setOnItemClickListener { unit ->
            val intent = Intent(this, UnitDetailActivity::class.java)
            intent.putExtra("unit", unit)
            startActivity(intent)
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
