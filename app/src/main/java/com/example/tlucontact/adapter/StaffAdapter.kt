package com.example.tlucontact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tlucontact.R
import com.example.tlucontact.data.Staff

class StaffAdapter(private val staff: List<Staff>) :
    RecyclerView.Adapter<StaffAdapter.StaffViewHolder>() {

    private var onItemClickListener: ((Staff) -> Unit)? = null

    inner class StaffViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvStaffName: TextView = itemView.findViewById(R.id.tvStaffName)
        val tvStaffPhoneNumber: TextView = itemView.findViewById(R.id.tvStaffPhoneNumber)

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(staff[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_staff, parent, false)
        return StaffViewHolder(view)
    }

    override fun onBindViewHolder(holder: StaffViewHolder, position: Int) {
        val staffMember = staff[position]
        holder.tvStaffName.text = staffMember.name
        holder.tvStaffPhoneNumber.text = staffMember.phoneNumber
    }

    override fun getItemCount(): Int {
        return staff.size
    }

    fun setOnItemClickListener(listener: (Staff) -> Unit) {
        onItemClickListener = listener
    }
}