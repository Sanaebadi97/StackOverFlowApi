package info.sanaebadi.mapper.details

import info.sanaebadi.domain.model.user.*
import info.sanaebadi.entity.user.AnswerEntity
import info.sanaebadi.entity.user.AnswerListEntity
import info.sanaebadi.entity.user.QuestionEntity
import info.sanaebadi.entity.user.QuestionListEntity
import info.sanaebadi.mapper.base.DataLayerMapper
import java.util.ArrayList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoritesByUserMapper @Inject constructor() : DataLayerMapper<QuestionEntity, Question> {

    fun toDomain(questionListEntity: QuestionListEntity): QuestionList? {
        val quesList: MutableList<Question> = ArrayList<Question>()

        for (question: QuestionEntity in questionListEntity.items) {
            quesList.add(toDomain(question))
        }
        return QuestionList(quesList)
    }

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