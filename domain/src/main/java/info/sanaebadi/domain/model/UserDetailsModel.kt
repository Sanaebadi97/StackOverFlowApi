package info.sanaebadi.domain.model

import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.domain.model.details.AnswerViewModel
import info.sanaebadi.domain.model.details.QuestionViewModel

data class UserDetailsModel(
    val questions: List<QuestionViewModel>,
    val answers: List<AnswerViewModel>,
    val favorites: List<QuestionViewModel>
) : ViewType {
    override fun getViewType(): Int {
        TODO("Not yet implemented")
    }
}