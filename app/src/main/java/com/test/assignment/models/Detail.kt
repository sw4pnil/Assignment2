package com.test.assignment.models

import android.os.Parcel
import android.os.Parcelable

/**
 * @author swapnil tripathi 5 july
 * Detail data to show
 */


class Detail() : Parcelable {

    private var title: String? = null
    private var type: String? = null
    private var url: String? = null
    private var by: String? = null


    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }



    fun getImageHref(): String? {
        return url
    }

    fun setImageHref(url: String?) {
        this.url = url
    }

    fun getBy(): String? {
        return by
    }

    fun setby(by: String?) {
        this.by = by
    }


    fun Detail(by: String?, title: String?, url: String?) {
        this.by = by
        this.title = title
        this.url = url

    }

    fun Detail() {}

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        by = parcel.readString()
        url = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(by)
        parcel.writeString(url)

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Detail(by=$by, title=$title, url=$url)"
    }

    companion object CREATOR : Parcelable.Creator<Detail> {
        override fun createFromParcel(parcel: Parcel): Detail {
            return Detail(parcel)
        }

        override fun newArray(size: Int): Array<Detail?> {
            return arrayOfNulls(size)
        }
    }
}