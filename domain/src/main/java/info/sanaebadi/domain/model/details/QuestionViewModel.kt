package info.sanaebadi.domain.model.details

import info.sanaebadi.domain.model.base.AdapterConstants
import info.sanaebadi.domain.model.base.ViewType

data class QuestionViewModel(
    val viewCount: Long,
    val score: Long,
    val title: String,
    val link: String,
    val questionId: Long
) : ViewType {
    override fun getViewType(): Int = AdapterConstants.QUESTION

}