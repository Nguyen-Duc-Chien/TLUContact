package com.example.tlucontact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tlucontact.R
import com.example.tlucontact.data.Staff

class StaffAdapter(private var staff: List<Staff>) :
    RecyclerView.Adapter<StaffAdapter.StaffViewHolder>() {

    private var filteredStaff: List<Staff> = staff

    inner class StaffViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvStaffName: TextView = itemView.findViewById(R.id.tvStaffName)
        val tvStaffPhoneNumber: TextView = itemView.findViewById(R.id.tvStaffPhoneNumber)

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(filteredStaff[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_staff, parent, false)
        return StaffViewHolder(view)
    }

    override fun onBindViewHolder(holder: StaffViewHolder, position: Int) {
        val staffMember = filteredStaff[position]
        holder.tvStaffName.text = staffMember.name
        holder.tvStaffPhoneNumber.text = staffMember.phoneNumber
    }

    override fun getItemCount(): Int {
        return filteredStaff.size
    }

    fun filter(query: String) {
        filteredStaff = if (query.isEmpty()) {
            staff
        } else {
            staff.filter { it.name.contains(query, ignoreCase = true) }
        }
        notifyDataSetChanged()
    }

    private var onItemClickListener: ((Staff) -> Unit)? = null

    fun setOnItemClickListener(listener: (Staff) -> Unit) {
        onItemClickListener = listener
    }
}