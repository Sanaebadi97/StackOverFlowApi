package info.sanaebadi.domain.model.details

import info.sanaebadi.domain.model.base.AdapterConstants
import info.sanaebadi.domain.model.base.ViewType

data class AnswerViewModel(
    val answerId: Long,
    val score: Long,
    val accepted: Boolean,
    val questionTitle: String
) : ViewType {

    override fun getViewType() = AdapterConstants.ANSWER
}