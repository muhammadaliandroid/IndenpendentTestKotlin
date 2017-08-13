package uk.co.mali.independenttest.model.pojo.kotlin

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import uk.co.mali.independenttest.model.pojo.kotlin.Article


/**
 * Created by alig2 on 22/06/2017.
 */

class Data : Parcelable {

    @SerializedName("feeds")
    @Expose
    var feeds: Feeds? = null
    @SerializedName("articles")
    @Expose
    var articles: List<Article>? = null
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
        dest.writeParcelable(this.feeds, flags)
        dest.writeTypedList(this.articles)
        dest.writeString(this.section)
        dest.writeString(this.url)
    }

    constructor() {}

    protected constructor(`in`: Parcel) {
        this.feeds = `in`.readParcelable<Feeds>(Feeds::class.java.classLoader)
        this.articles = `in`.createTypedArrayList(Article.CREATOR)
        this.section = `in`.readString()
        this.url = `in`.readString()
    }

    companion object {

        val CREATOR: Parcelable.Creator<Data> = object : Parcelable.Creator<Data> {
            override fun createFromParcel(source: Parcel): Data {
                return Data(source)
            }

            override fun newArray(size: Int): Array<Data?> {
                return arrayOfNulls(size)
            }
        }
    }
}
