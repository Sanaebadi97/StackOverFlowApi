package info.sanaebadi.entity.user

import com.squareup.moshi.JsonClass
import info.sanaebadi.data.entity.base.BaseEntity

@JsonClass(generateAdapter = true)
class QuestionList(val items: List<Question>): BaseEntity