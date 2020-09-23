package info.sanaebadi.entity.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import info.sanaebadi.data.entity.base.BaseEntity

@JsonClass(generateAdapter = true)
data class Owner(@field:Json(name ="user_id") var userId: Long) : BaseEntity {

    constructor() : this(-1)
}