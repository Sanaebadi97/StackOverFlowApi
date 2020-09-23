package info.sanaebadi.entity.user

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class AnswerListEntity(val items: List<AnswerEntity>)