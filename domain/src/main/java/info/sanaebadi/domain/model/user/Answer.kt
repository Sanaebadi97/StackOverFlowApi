package info.sanaebadi.domain.model.user

import info.sanaebadi.domain.model.base.BaseDomainModel

data class Answer(
    var answerId: Long,
    var questionId: Long,
    var score: Long,
    var accepted: Boolean,
    var ownerEntity: Owner
) : BaseDomainModel {

    constructor() : this(-1, -1, 0, false, Owner())
}