package info.sanaebadi.stackoverflowproject.model.user

import android.os.Parcel
import android.os.Parcelable
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.stackoverflowproject.model.base.AdapterConstants
import info.sanaebadi.stackoverflowproject.model.base.PresentationModel


data class UserPresentation(
    var userId: Long,
    var displayName: String,
    var reputation: Long,
    var profileImage: String
) : PresentationModel , Parcelable , ViewType {

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readLong(),
        parcel.readString()!!
    ) {
    }

    constructor() : this(-1, "", 0, "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(userId)
        parcel.writeString(displayName)
        parcel.writeLong(reputation)
        parcel.writeString(profileImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserPresentation> {
        override fun createFromParcel(parcel: Parcel): UserPresentation {
            return UserPresentation(parcel)
        }

        override fun newArray(size: Int): Array<UserPresentation?> {
            return arrayOfNulls(size)
        }
    }

    override fun getViewType(): Int = AdapterConstants.USER_DETAILS
}