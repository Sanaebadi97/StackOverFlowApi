package info.sanaebadi.repository.dataSourceImpl

import info.sanaebadi.entity.user.AnswerListEntity
import info.sanaebadi.entity.user.QuestionListEntity
import info.sanaebadi.networking.base.AbstractService
import info.sanaebadi.networking.retrofit.UserApiRetrofitService
import info.sanaebadi.repository.dataSource.details.DetailsDataSource
import io.reactivex.Single

class DetailsOnlineDataSource :
    AbstractService<UserApiRetrofitService>(UserApiRetrofitService::class.java), DetailsDataSource {

    override fun getQuestionsByUser(userId: Long): Single<QuestionListEntity> {
        return service.getQuestionsByUser(userId)
    }

    override fun getAnswersByUser(userId: Long): Single<AnswerListEntity> {
        return service.getAnswersByUser(userId)
    }

    override fun getFavoritesByUser(userId: Long): Single<QuestionListEntity> {
        return service.getFavoritesByUser(userId)
    }

    override fun getQuestionsById(ids: List<Long>, userId: Long): Single<QuestionListEntity> {
        return getQuestionsById(ids, userId)
    }


}