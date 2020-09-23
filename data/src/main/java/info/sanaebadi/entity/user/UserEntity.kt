package info.sanaebadi.entity.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import info.sanaebadi.data.entity.base.BaseEntity

@JsonClass(generateAdapter = true)
data class UserEntity(
    @field:Json(name ="user_id")  var userId: Long,
    @field:Json(name ="display_name") var displayName: String,
    @field:Json(name ="reputation") var reputation: Long,
    @field:Json(name ="profile_image") var profileImage: String
):BaseEntity {

    constructor() : this(-1, "", 0, "")
}