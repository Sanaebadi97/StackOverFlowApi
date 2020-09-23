package info.sanaebadi.stackoverflowproject.model.user

import info.sanaebadi.stackoverflowproject.model.base.PresentationModel

data class FavoriteByUser(
     var userId: Long,
    var questionIds: List<Long>
): PresentationModel {

    constructor() : this(-1, emptyList())
}