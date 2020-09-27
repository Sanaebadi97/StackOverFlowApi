package info.sanaebadi.stackoverflowproject.model.user

import info.sanaebadi.stackoverflowproject.model.base.PresentationModel

data class AnswerPresentation(
    var answerId: Long,
    var questionId: Long,
    var score: Long,
    var accepted: Boolean,
    var ownerEntity: OwnerPresentation
) : PresentationModel {

    constructor() : this(-1, -1, 0, false, OwnerPresentation())
}