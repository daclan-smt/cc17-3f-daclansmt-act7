package com.example.taratagaytay.models

import android.os.Parcel
import android.os.Parcelable

data class Recommendation(
    val imageResId: Int,
    val title: String,
    val description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResId)
        parcel.writeString(title)
        parcel.writeString(description)
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Recommendation> {
            override fun createFromParcel(parcel: Parcel): Recommendation {
                return Recommendation(parcel)
            }

            override fun newArray(size: Int): Array<Recommendation?> {
                return arrayOfNulls(size)
            }
        }
    }
}
