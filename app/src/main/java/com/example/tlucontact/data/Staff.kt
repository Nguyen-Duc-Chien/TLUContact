package com.example.tlucontact.data

import android.os.Parcel
import android.os.Parcelable

data class Staff(
    val id: Int,
    val name: String,
    val position: String,
    val phoneNumber: String,
    val email: String,
    val department: String // Ensure the department field is correctly named
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(position)
        parcel.writeString(phoneNumber)
        parcel.writeString(email)
        parcel.writeString(department)
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