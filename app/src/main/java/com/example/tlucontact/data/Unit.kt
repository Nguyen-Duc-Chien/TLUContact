package com.example.tlucontact.data

import android.os.Parcel
import android.os.Parcelable

data class OrgUnit(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val address: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(phoneNumber)
        parcel.writeString(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OrgUnit> {
        override fun createFromParcel(parcel: Parcel): OrgUnit {
            return OrgUnit(parcel)
        }

        override fun newArray(size: Int): Array<OrgUnit?> {
            return arrayOfNulls(size)
        }
    }
}