package info.sanaebadi.stackoverflowproject.model.user

import info.sanaebadi.stackoverflowproject.model.base.PresentationModel

data class AnswerPre(
    var answerId: Long,
    var questionId: Long,
    var score: Long,
    var accepted: Boolean,
    var ownerEntity: OwnerPre
) : PresentationModel {

    constructor() : this(-1, -1, 0, false, OwnerPre())
}