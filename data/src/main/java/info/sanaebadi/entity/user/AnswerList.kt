package info.sanaebadi.entity.user

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class AnswerList(val items: List<Answer>)