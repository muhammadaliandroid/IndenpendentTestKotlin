package uk.co.mali.independenttest.model.pojo.kotlin

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by alig2 on 22/06/2017.
 */

class Author : Parcelable {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("twitter_handle")
    @Expose
    var twitterHandle: String? = null

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.name)
        dest.writeString(this.twitterHandle)
    }

    constructor() {}

    protected constructor(`in`: Parcel) {
        this.name = `in`.readString()
        this.twitterHandle = `in`.readString()
    }

    companion object {

        val CREATOR: Parcelable.Creator<Author> = object : Parcelable.Creator<Author> {
            override fun createFromParcel(source: Parcel): Author {
                return Author(source)
            }

            override fun newArray(size: Int): Array<Author?> {
                return arrayOfNulls(size)
            }
        }
    }
}
