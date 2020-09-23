package info.sanaebadi.domain.model.user

import info.sanaebadi.domain.model.base.BaseDomainModel

data class FavoritedByUser(
     var userId: Long,
    var questionIds: List<Long>
): BaseDomainModel {

    constructor() : this(-1, emptyList())
}