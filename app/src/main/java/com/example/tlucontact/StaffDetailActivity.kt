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
import com.example.tlucontact.data.SampleData
import com.example.tlucontact.data.Staff

class StaffDetailActivity : AppCompatActivity() {

    private lateinit var staff: Staff
    private lateinit var tvStaffDetailName: TextView
    private lateinit var tvStaffDetailPosition: TextView
    private lateinit var tvStaffDetailPhoneNumber: TextView
    private lateinit var tvStaffDetailEmail: TextView
    private lateinit var tvStaffDetailDepartment: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        staff = intent.getParcelableExtra("staff")!!

        val ivAvatar = findViewById<ImageView>(R.id.ivAvatar)
        tvStaffDetailName = findViewById(R.id.tvStaffDetailName)
        tvStaffDetailPosition = findViewById(R.id.tvStaffDetailPosition)
        tvStaffDetailPhoneNumber = findViewById(R.id.tvStaffDetailPhoneNumber)
        tvStaffDetailEmail = findViewById(R.id.tvStaffDetailEmail)
        tvStaffDetailDepartment = findViewById(R.id.tvStaffDetailDepartment)
        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnMessage = findViewById<Button>(R.id.btnMessage)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnDelete = findViewById<Button>(R.id.btnDelete)

        ivAvatar.setImageResource(R.drawable.avatar)

        tvStaffDetailName.text = staff.name
        tvStaffDetailPosition.text = staff.position
        tvStaffDetailPhoneNumber.text = staff.phoneNumber
        tvStaffDetailEmail.text = staff.email
        tvStaffDetailDepartment.text = staff.department

        btnCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:${staff.phoneNumber}")
            startActivity(callIntent)
        }

        btnMessage.setOnClickListener {
            val messageIntent = Intent(Intent.ACTION_VIEW)
            messageIntent.data = Uri.parse("sms:${staff.phoneNumber}")
            startActivity(messageIntent)
        }

        btnEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:${staff.email}")
            startActivity(emailIntent)
        }

        btnEdit.setOnClickListener {
            val editIntent = Intent(this, EditStaffActivity::class.java)
            editIntent.putExtra("staff", staff)
            startActivityForResult(editIntent, EDIT_STAFF_REQUEST_CODE)
        }

        btnDelete.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Xóa nhân viên")
                .setMessage("Bạn có chắc chắn muốn xóa nhân viên này?")
                .setPositiveButton("Xóa") { dialog, which ->
                    SampleData.removeStaff(staff.id)
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
        if (requestCode == EDIT_STAFF_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val updatedStaff = data?.getParcelableExtra<Staff>("updatedStaff")
            if (updatedStaff != null) {
                SampleData.updateStaff(updatedStaff)
                staff = updatedStaff
                tvStaffDetailName.text = staff.name
                tvStaffDetailPosition.text = staff.position
                tvStaffDetailPhoneNumber.text = staff.phoneNumber
                tvStaffDetailEmail.text = staff.email
                tvStaffDetailDepartment.text = staff.department
                setResult(Activity.RESULT_OK) // Notify that the data has changed
            }
        }
    }

    companion object {
        private const val EDIT_STAFF_REQUEST_CODE = 1
    }
}