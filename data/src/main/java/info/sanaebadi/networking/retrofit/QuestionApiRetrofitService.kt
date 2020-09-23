package info.sanaebadi.networking.retrofit

import info.sanaebadi.entity.user.QuestionList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface QuestionApiRetrofitService {
    @GET("/questions/{questionIds}?order=desc&sort=activity&site=stackoverflow")
    fun getQuestionsById(@Path("questionIds") questionId: String): Single<QuestionList>
}