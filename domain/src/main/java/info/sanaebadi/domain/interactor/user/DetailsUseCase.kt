package info.sanaebadi.domain.interactor.user

import info.sanaebadi.domain.model.UserDetailsModel
import info.sanaebadi.domain.model.user.Answer
import info.sanaebadi.domain.model.user.Question
import info.sanaebadi.domain.repository.DetailsRepository
import io.reactivex.Single
import javax.inject.Inject

class DetailsUseCase @Inject constructor(private val detailsRepository: DetailsRepository) {

    fun execute(userId: Long): Single<UserDetailsModel> {
        return Single.zip(
            detailsRepository.getQuestionsByUser(userId)
                    getTitlesForAnswers (userId),
            detailsRepository.getFavoritesByUser(userId),
            Function3<List<Question>, List<Answer>, List<Question>, UserDetailsModel>
            { questions, answers, favorites ->
                createDetailsModel(questions, answers, favorites)
            })
    }

    private fun getTitlesForAnswers(userId: Long): Single<List<Answer>> {
        return detailsRepository.getAnswersByUser(userId)
            .flatMap { answers: List<Answer> ->
                mapAnswersToAnswerViewModels(answers, userId)
            }
    }

    private fun mapAnswersToAnswerViewModels(
        answers: List<Answer>,
        userId: Long
    ): Single<List<Answer>> {
        val ids = answers
            .map { it.questionId }

        val questionsById = detailsRepository.getQuestionsById(ids, userId)

        return questionsById
            .map { questions: List<Question> ->
                createAnswerViewModels(answers, questions)
            }
    }

    private fun createAnswerViewModels(
        answers: List<Answer>,
        questions: List<Question>
    ): List<Answer> {
        return answers.map { (answerId, questionId, score, accepted) ->
            val question = questions.find { it.questionId == questionId }
            Answer(answerId, score, accepted, question?.title ?: "Unknown", null)
        }
    }

    private fun createPlaceDataModel(
        questions: List<Question>,
        answers: List<Answer>,
        favorites: List<Question>
    ): UserDetailsModel {
        val questionViewModels =
            questions.map { Question(it.viewCount, it.score, it.title, it.link, it.questionId) }
        val favoriteViewModels =
            favorites.map { Question(it.viewCount, it.score, it.title, it.link, it.questionId) }

        return UserDetailsModel(questionViewModels, answers, favoriteViewModels)
    }

}