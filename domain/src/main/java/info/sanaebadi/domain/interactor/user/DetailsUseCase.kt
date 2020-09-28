package info.sanaebadi.domain.interactor.user

import info.sanaebadi.domain.model.UserDetailsModel
import info.sanaebadi.domain.model.details.AnswerViewModel
import info.sanaebadi.domain.model.details.QuestionViewModel
import info.sanaebadi.domain.model.user.Answer
import info.sanaebadi.domain.model.user.Question
import info.sanaebadi.domain.repository.DetailsRepository
import io.reactivex.Single
import javax.inject.Inject

class DetailsUseCase @Inject constructor(private val detailsRepository: DetailsRepository) {

    fun execute(userId: Long): Single<UserDetailsModel> {
        return Single.zip(
            detailsRepository.getQuestionsByUser(userId),
            getTitlesForAnswers(userId),
            detailsRepository.getFavoritesByUser(userId),
            { questions, answers, favorites ->
                createDetailsModel(questions, answers, favorites)
            })
    }

    private fun getTitlesForAnswers(userId: Long): Single<List<AnswerViewModel>> {
        return detailsRepository.getAnswersByUser(userId)
            .flatMap { answers: List<Answer> ->
                mapAnswersToAnswerViewModels(answers, userId)
            }
    }

    private fun mapAnswersToAnswerViewModels(
        answers: List<Answer>,
        userId: Long
    ): Single<List<AnswerViewModel>> {
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
    ): List<AnswerViewModel> {
        return answers.map { (answerId, questionId, score, accepted) ->
            val question = questions.find { it.questionId == questionId }
            AnswerViewModel(answerId, score, accepted, question?.title ?: "Unknown")
        }
    }

    private fun createDetailsModel(
        questions: List<Question>,
        answers: List<AnswerViewModel>,
        favorites: List<Question>
    ): UserDetailsModel {
        val questionViewModels =
            questions.map {
                QuestionViewModel(
                    it.viewCount,
                    it.score,
                    it.title,
                    it.link,
                    it.questionId
                )
            }
        val favoriteViewModels =
            favorites.map {
                QuestionViewModel(
                    it.viewCount,
                    it.score,
                    it.title,
                    it.link,
                    it.questionId
                )
            }

        return UserDetailsModel(questionViewModels, answers, favoriteViewModels)
    }

}