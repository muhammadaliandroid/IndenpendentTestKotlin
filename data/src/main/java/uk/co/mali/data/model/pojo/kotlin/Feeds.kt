package uk.co.mali.independenttest.model.pojo.kotlin


import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by alig2 on 22/06/2017.
 */

class Feeds : Parcelable {

    @SerializedName("section")
    @Expose
    var section: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.section)
        dest.writeString(this.url)
    }

    constructor() {}

    protected constructor(`in`: Parcel) {
        this.section = `in`.readString()
        this.url = `in`.readString()
    }

    companion object {

        val CREATOR: Parcelable.Creator<Feeds> = object : Parcelable.Creator<Feeds> {
            override fun createFromParcel(source: Parcel): Feeds {
                return Feeds(source)
            }

            override fun newArray(size: Int): Array<Feeds?> {
                return arrayOfNulls(size)
            }
        }
    }
}
