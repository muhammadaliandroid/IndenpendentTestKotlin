package uk.co.mali.independenttest.model.pojo.kotlin

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import uk.co.mali.independenttest.model.pojo.kotlin.Author
import uk.co.mali.independenttest.model.pojo.kotlin.Image
import java.util.*

class Article : Parcelable {

    @SerializedName("guid")
    @Expose
    var guid: String? = null
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("headline_override")
    @Expose
    var headlineOverride: String? = null
    @SerializedName("headline")
    @Expose
    var headline: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("authors")
    @Expose
    var authors: List<Author>? = null
    @SerializedName("updated_date")
    @Expose
    var updatedDate: String? = null
    @SerializedName("editorial_priority")
    @Expose
    var editorialPriority: String? = null
    @SerializedName("short_headline")
    @Expose
    var shortHeadline: String? = null
    @SerializedName("sub_headline")
    @Expose
    var subHeadline: String? = null
    @SerializedName("author")
    @Expose
    var author: String? = null
    @SerializedName("local_caption")
    @Expose
    var localCaption: String? = null
    @SerializedName("comments_setting")
    @Expose
    var commentsSetting: String? = null
    @SerializedName("publish_date")
    @Expose
    var publishDate: String? = null
    @SerializedName("topics")
    @Expose
    var topics: List<String>? = null
    @SerializedName("tags")
    @Expose
    var tags: List<String>? = null
    @SerializedName("section")
    @Expose
    var section: String? = null
    @SerializedName("section_url")
    @Expose
    var sectionUrl: String? = null
    @SerializedName("image")
    @Expose
    var image: Image? = null
    @SerializedName("body")
    @Expose
    var body: String? = null

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.guid)
        dest.writeString(this.state)
        dest.writeString(this.headlineOverride)
        dest.writeString(this.headline)
        dest.writeString(this.url)
        dest.writeString(this.link)
        dest.writeList(this.authors)
        dest.writeString(this.updatedDate)
        dest.writeString(this.editorialPriority)
        dest.writeString(this.shortHeadline)
        dest.writeString(this.subHeadline)
        dest.writeString(this.author)
        dest.writeString(this.localCaption)
        dest.writeString(this.commentsSetting)
        dest.writeString(this.publishDate)
        dest.writeStringList(this.topics)
        dest.writeStringList(this.tags)
        dest.writeString(this.section)
        dest.writeString(this.sectionUrl)
        dest.writeParcelable(this.image, flags)
        dest.writeString(this.body)
    }

    constructor() {}

    protected constructor(`in`: Parcel) {
        this.guid = `in`.readString()
        this.state = `in`.readString()
        this.headlineOverride = `in`.readString()
        this.headline = `in`.readString()
        this.url = `in`.readString()
        this.link = `in`.readString()
        this.authors = ArrayList<Author>()
        `in`.readList(this.authors, Author::class.java.classLoader)
        this.updatedDate = `in`.readString()
        this.editorialPriority = `in`.readString()
        this.shortHeadline = `in`.readString()
        this.subHeadline = `in`.readString()
        this.author = `in`.readString()
        this.localCaption = `in`.readString()
        this.commentsSetting = `in`.readString()
        this.publishDate = `in`.readString()
        this.topics = `in`.createStringArrayList()
        this.tags = `in`.createStringArrayList()
        this.section = `in`.readString()
        this.sectionUrl = `in`.readString()
        this.image = `in`.readParcelable<Image>(Image::class.java.classLoader)
        this.body = `in`.readString()
    }

    companion object {

        val CREATOR: Parcelable.Creator<Article> = object : Parcelable.Creator<Article> {
            override fun createFromParcel(source: Parcel): Article {
                return Article(source)
            }

            override fun newArray(size: Int): Array<Article?> {
                return arrayOfNulls(size)
            }
        }
    }
}
