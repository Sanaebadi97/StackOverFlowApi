package info.sanaebadi.mapper.details

import info.sanaebadi.domain.model.user.Answer
import info.sanaebadi.domain.model.user.AnswerList
import info.sanaebadi.domain.model.user.Owner
import info.sanaebadi.entity.user.AnswerEntity
import info.sanaebadi.entity.user.AnswerListEntity
import info.sanaebadi.mapper.base.DataLayerMapper
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnswersByUserMapper @Inject constructor() : DataLayerMapper<AnswerEntity, Answer> {

    fun toDomain(answerListEntity: AnswerListEntity): AnswerList? {
        val answerList: MutableList<Answer> = ArrayList<Answer>()

        for (answer: AnswerEntity in answerListEntity.items) {
            answerList.add(toDomain(answer))
        }
        return AnswerList(answerList)
    }

    override fun toDomain(e: AnswerEntity?): Answer {
        return Answer(e?.answerId!!, e.questionId, e.score, e.accepted, ownerEntity = Owner())
    }

    override fun toEntity(d: Answer?): AnswerEntity? {
        return null
    }
}