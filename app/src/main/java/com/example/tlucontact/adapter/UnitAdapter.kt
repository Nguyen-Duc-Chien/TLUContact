package com.example.tlucontact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tlucontact.R
import com.example.tlucontact.data.OrgUnit // Đổi từ Unit -> OrgUnit

class UnitAdapter(private val units: List<OrgUnit>) :
    RecyclerView.Adapter<UnitAdapter.UnitViewHolder>() {

    private var onItemClickListener: ((OrgUnit) -> Unit)? = null

    inner class UnitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUnitName: TextView = itemView.findViewById(R.id.tvUnitName)
        val tvUnitPhoneNumber: TextView = itemView.findViewById(R.id.tvUnitPhoneNumber)

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(units[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_unit, parent, false)
        return UnitViewHolder(view)
    }

    override fun onBindViewHolder(holder: UnitViewHolder, position: Int) {
        val unit = units[position]
        holder.tvUnitName.text = unit.name
        holder.tvUnitPhoneNumber.text = unit.phoneNumber
    }

    override fun getItemCount(): Int {
        return units.size
    }

    fun setOnItemClickListener(listener: (OrgUnit) -> Unit) {
        onItemClickListener = listener
    }
}
