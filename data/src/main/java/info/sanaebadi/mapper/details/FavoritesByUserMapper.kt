package info.sanaebadi.mapper.details

import info.sanaebadi.domain.model.user.Owner
import info.sanaebadi.domain.model.user.Question
import info.sanaebadi.entity.user.QuestionEntity
import info.sanaebadi.mapper.base.DataLayerMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoritesByUserMapper @Inject constructor() : DataLayerMapper<QuestionEntity, Question> {
    override fun toDomain(e: QuestionEntity?): Question {
        return Question(
            e?.viewCount!!,
            e.score,
            e.title,
            e.link,
            e.questionId,
            ownerEntity = Owner()
        )
    }

    override fun toEntity(d: Question?): QuestionEntity? {
        return null
    }
}