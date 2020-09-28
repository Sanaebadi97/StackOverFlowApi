package info.sanaebadi.repository.dataSource.details

import info.sanaebadi.entity.user.AnswerListEntity
import info.sanaebadi.entity.user.QuestionListEntity
import io.reactivex.Single


interface DetailsDataSource {
    fun getQuestionsByUser(userId: Long): Single<QuestionListEntity>
    fun getAnswersByUser(userId: Long): Single<AnswerListEntity>
    fun getFavoritesByUser(userId: Long): Single<QuestionListEntity>
    fun getQuestionsById(ids: List<Long>, userId: Long): Single<QuestionListEntity>
}