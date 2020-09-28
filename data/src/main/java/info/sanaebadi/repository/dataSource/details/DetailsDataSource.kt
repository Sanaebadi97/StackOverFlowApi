package info.sanaebadi.repository.dataSource.details

import info.sanaebadi.entity.user.AnswerEntity
import info.sanaebadi.entity.user.QuestionEntity
import io.reactivex.Single


interface DetailsDataSource {
    fun getQuestionsByUser(userId: Long): Single<List<QuestionEntity>>
    fun getAnswersByUser(userId: Long): Single<List<AnswerEntity>>
    fun getFavoritesByUser(userId: Long): Single<List<QuestionEntity>>
    fun getQuestionsById(ids: List<Long>, userId: Long): Single<List<QuestionEntity>>
}