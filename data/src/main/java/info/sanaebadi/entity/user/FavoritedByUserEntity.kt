package info.sanaebadi.entity.user

import com.squareup.moshi.JsonClass
import info.sanaebadi.data.entity.base.BaseEntity

@JsonClass(generateAdapter = true)
data class FavoritedByUserEntity(
     var userId: Long,
    var questionIds: List<Long>
): BaseEntity {

    constructor() : this(-1, emptyList())
}