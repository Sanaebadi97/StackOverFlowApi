package info.sanaebadi.domain.repository

import info.sanaebadi.domain.model.user.Answer
import info.sanaebadi.domain.model.user.Question
import io.reactivex.Single

interface DetailsRepository {
    fun getQuestionsByUser(userId: Long): Single<List<Question>>
    fun getAnswersByUser(userId: Long): Single<List<Answer>>
    fun getFavoritesByUser(userId: Long): Single<List<Question>>
    fun getQuestionsById(ids: List<Long>, userId: Long): Single<List<Question>>
}