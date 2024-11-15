package com.example.taratagaytay.models

import android.os.Parcel
import android.os.Parcelable

data class Category(
    val name: String,
    val imageResId: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(imageResId)
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Category> {
            override fun createFromParcel(parcel: Parcel): Category {
                return Category(parcel)
            }

            override fun newArray(size: Int): Array<Category?> {
                return arrayOfNulls(size)
            }
        }
    }
}
