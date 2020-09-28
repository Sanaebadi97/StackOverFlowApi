package info.sanaebadi.domain.model.details

import info.sanaebadi.domain.model.base.AdapterConstants
import info.sanaebadi.domain.model.base.BaseDomainModel
import info.sanaebadi.domain.model.base.ViewType


data class AnswerViewModel(
    val answerId: Long,
    val score: Long,
    val accepted: Boolean,
    val questionTitle: String
) : BaseDomainModel, ViewType {
    override fun getViewType() = AdapterConstants.ANSWER
}