package uk.co.mali.independenttest.model.pojo.kotlin

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Image : Parcelable {

    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null
    @SerializedName("copyright")
    @Expose
    var copyright: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("caption")
    @Expose
    var caption: String? = null

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.url)
        dest.writeString(this.thumbnail)
        dest.writeString(this.copyright)
        dest.writeString(this.title)
        dest.writeString(this.caption)
    }

    constructor() {}

    protected constructor(`in`: Parcel) {
        this.url = `in`.readString()
        this.thumbnail = `in`.readString()
        this.copyright = `in`.readString()
        this.title = `in`.readString()
        this.caption = `in`.readString()
    }

    companion object {

        val CREATOR: Parcelable.Creator<Image> = object : Parcelable.Creator<Image> {
            override fun createFromParcel(source: Parcel): Image {
                return Image(source)
            }

            override fun newArray(size: Int): Array<Image?> {
                return arrayOfNulls(size)
            }
        }
    }
}
