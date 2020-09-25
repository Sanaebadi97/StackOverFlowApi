package info.sanaebadi.stackoverflowproject.model.user

import android.os.Parcel
import android.os.Parcelable
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.stackoverflowproject.model.base.AdapterConstants
import info.sanaebadi.stackoverflowproject.model.base.PresentationModel


class UserListModelPre(
     val userId: Long,
     val displayName: String,
     val reputation: Long,
     val profileImage: String
) : PresentationModel, Parcelable, ViewType {
    override fun getViewType(): Int = AdapterConstants.USER_DETAILS

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<UserListModelPre> =
            object : Parcelable.Creator<UserListModelPre> {
                override fun createFromParcel(source: Parcel): UserListModelPre =
                    UserListModelPre(source)

                override fun newArray(size: Int): Array<UserListModelPre?> = arrayOfNulls(size)
            }
    }
    constructor(source: Parcel) : this(
        source.readLong(),
        source.readString().toString(),
        source.readLong(),
        source.readString().toString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(userId)
        dest.writeString(displayName)
        dest.writeLong(reputation)
        dest.writeString(profileImage)
    }
}