package info.sanaebadi.domain.repository

import info.sanaebadi.domain.model.user.AnswerList
import info.sanaebadi.domain.model.user.QuestionList
import io.reactivex.Single

interface DetailsRepository {
    fun getQuestionsByUser(userId: Long): Single<QuestionList>
    fun getAnswersByUser(userId: Long): Single<AnswerList>
    fun getFavoritesByUser(userId: Long): Single<QuestionList>
    fun getQuestionsById(ids: List<Long>, userId: Long): Single<QuestionList>
}