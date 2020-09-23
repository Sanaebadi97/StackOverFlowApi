package info.sanaebadi.entity.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import info.sanaebadi.data.entity.base.BaseEntity

@JsonClass(generateAdapter = true)
data class AnswerEntity(
    @field:Json(name = "answer_id") var answerId: Long,
    @field:Json(name = "question_id") var questionId: Long,
    @field:Json(name = "score") var score: Long,
    @field:Json(name = "is_accepted") var accepted: Boolean,
    @field:Json(name = "owner") var ownerEntity: OwnerEntity
) :BaseEntity{

    constructor() : this(-1, -1, 0, false, OwnerEntity())
}