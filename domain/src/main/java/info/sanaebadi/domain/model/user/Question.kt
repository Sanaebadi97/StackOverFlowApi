package info.sanaebadi.domain.model.user

import info.sanaebadi.domain.model.base.AdapterConstants
import info.sanaebadi.domain.model.base.BaseDomainModel
import info.sanaebadi.domain.model.base.ViewType


data class Question(
    var viewCount: Long,
    var score: Long,
    var title: String,
    var link: String,
    var questionId: Long,
    var ownerEntity: Owner
) : BaseDomainModel, ViewType {
    override fun getViewType(): Int = AdapterConstants.QUESTION
}