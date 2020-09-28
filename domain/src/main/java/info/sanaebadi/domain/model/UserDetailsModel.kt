package info.sanaebadi.domain.model

import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.domain.model.user.Answer
import info.sanaebadi.domain.model.user.Question

data class UserDetailsModel(
    val questions: List<Question>,
    val answers: List<Answer>,
    val favorites: List<Question>
) : ViewType {
    override fun getViewType(): Int {
        TODO("Not yet implemented")
    }
}