package info.sanaebadi.stackoverflowproject.model.user

import info.sanaebadi.stackoverflowproject.model.base.PresentationModel


data class QuestionPre(
    var viewCount: Long,
    var score: Long,
    var title: String,
    var link: String,
    var questionId: Long,
    var ownerEntity: OwnerPre
) : PresentationModel {


    constructor() : this(0, 0, "", "", -1, OwnerPre())
}