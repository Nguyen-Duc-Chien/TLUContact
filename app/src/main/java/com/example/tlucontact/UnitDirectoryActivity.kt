package com.example.tlucontact

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tlucontact.adapter.UnitAdapter
import com.example.tlucontact.data.SampleData

class UnitDirectoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_directory)

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
}
