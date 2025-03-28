package com.example.tlucontact.data

import android.os.Parcel
import android.os.Parcelable

data class OrgUnit( // Đổi tên từ Unit -> OrgUnit
    val name: String,
    val phoneNumber: String,
    val address: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
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
