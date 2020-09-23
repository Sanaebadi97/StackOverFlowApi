package info.sanaebadi.entity.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import info.sanaebadi.data.entity.base.BaseEntity

@JsonClass(generateAdapter = true)
data class Question(
    @field:Json(name ="view_count") var viewCount: Long,
    @field:Json(name ="score") var score: Long,
    @field:Json(name ="title") var title: String,
    @field:Json(name ="link") var link: String,
    @field:Json(name ="question_id") var questionId: Long,
    @field:Json(name ="owner") var owner: Owner
): BaseEntity {

    constructor() : this(0, 0, "", "", -1, Owner())
}