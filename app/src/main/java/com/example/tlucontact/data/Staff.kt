package com.example.tlucontact.data

import android.os.Parcel
import android.os.Parcelable

data class Staff(
    val name: String,
    val position: String,
    val phoneNumber: String,
    val email: String,
    val unit: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(position)
        parcel.writeString(phoneNumber)
        parcel.writeString(email)
        parcel.writeString(unit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Staff> {
        override fun createFromParcel(parcel: Parcel): Staff {
            return Staff(parcel)
        }

        override fun newArray(size: Int): Array<Staff?> {
            return arrayOfNulls(size)
        }
    }
}