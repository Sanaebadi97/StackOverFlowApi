package info.sanaebadi.repository.dataSource.details

import info.sanaebadi.domain.model.user.Answer
import info.sanaebadi.domain.model.user.AnswerList
import info.sanaebadi.domain.model.user.Question
import info.sanaebadi.domain.model.user.QuestionList
import info.sanaebadi.domain.repository.CacheStrategy
import info.sanaebadi.domain.repository.DetailsRepository
import info.sanaebadi.mapper.details.AnswersByUserMapper
import info.sanaebadi.mapper.details.FavoritesByUserMapper
import info.sanaebadi.mapper.details.QuestionByIdMapper
import info.sanaebadi.mapper.details.QuestionsByUserMapper
import io.reactivex.Single
import javax.inject.Inject

class DetailsDataRepository @Inject constructor(
    private val detailsDataSourceFactory: DetailsDataSourceFactory,
    private val answersByUserMapper: AnswersByUserMapper,
    private val favoritesByUserMapper: FavoritesByUserMapper,
    private val questionsByUserMapper: QuestionsByUserMapper,
    private val questionByIdMapper: QuestionByIdMapper

) : DetailsRepository {
    override fun getQuestionsByUser(userId: Long): Single<List<Question>> {
        return detailsDataSourceFactory.create(CacheStrategy.ONLINE_FIRST)
            .getQuestionsByUser(userId)
            .map { data -> questionsByUserMapper.toDomain(data) }
    }

    override fun getAnswersByUser(userId: Long): Single<List<Answer>> {
        return detailsDataSourceFactory.create(CacheStrategy.ONLINE_FIRST)
            .getAnswersByUser(userId)
            .map { data -> answersByUserMapper.toDomain(data) }
    }

    override fun getFavoritesByUser(userId: Long): Single<List<Question>> {
        return detailsDataSourceFactory.create(CacheStrategy.ONLINE_FIRST)
            .getFavoritesByUser(userId)
            .map { data -> favoritesByUserMapper.toDomain(data) }
    }

    override fun getQuestionsById(ids: List<Long>, userId: Long): Single<List<Question>> {
        return detailsDataSourceFactory.create(CacheStrategy.ONLINE_FIRST)
            .getQuestionsById(ids, userId)
            .map { data -> questionByIdMapper.toDomain(data) }
    }

}