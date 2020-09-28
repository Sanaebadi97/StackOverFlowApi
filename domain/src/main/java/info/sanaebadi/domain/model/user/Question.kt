package info.sanaebadi.domain.model.user

import info.sanaebadi.domain.model.base.BaseDomainModel


data class Question(
    var viewCount: Long,
    var score: Long,
    var title: String,
    var link: String,
    var questionId: Long,
    var ownerEntity: Owner
) : BaseDomainModel {


    constructor() : this(0, 0, "", "", -1, Owner())
}