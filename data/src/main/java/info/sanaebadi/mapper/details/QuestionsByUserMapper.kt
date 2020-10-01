package info.sanaebadi.mapper.details

import info.sanaebadi.domain.model.user.Owner
import info.sanaebadi.domain.model.user.Question
import info.sanaebadi.entity.user.QuestionEntity
import info.sanaebadi.entity.user.QuestionListEntity
import info.sanaebadi.mapper.base.DataLayerMapper
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuestionsByUserMapper @Inject constructor() : DataLayerMapper<QuestionEntity, Question> {

    fun toDomain(questionListEntity: QuestionListEntity): List<Question>? {
        val quesList: MutableList<Question> = ArrayList<Question>()

        for (question: QuestionEntity in questionListEntity.items) {
            quesList.add(toDomain(question))
        }
        return quesList
    }

    override fun toDomain(e: QuestionEntity?): Question {
        val owner = e?.ownerEntity?.userId?.let { Owner(it) }

        return Question(
            e?.viewCount!!,
            e.score,
            e.title,
            e.link,
            e.questionId,
            owner!!

        )
    }

    override fun toEntity(d: Question?): QuestionEntity? {
        return null
    }
}