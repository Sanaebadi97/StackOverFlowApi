package info.sanaebadi.networking.retrofit

import info.sanaebadi.entity.user.AnswerListEntity
import info.sanaebadi.entity.user.QuestionListEntity
import info.sanaebadi.entity.user.UserEntity
import info.sanaebadi.entity.user.UserListModelEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApiRetrofitService {
    @GET("users?order=desc&sort=reputation&site=stackoverflow")
    fun getUsers(@Query("page") page: Int = 1): Single<UserEntity>

    @GET("users/{userId}/questions?order=desc&sort=votes&site=stackoverflow")
    fun getQuestionsByUser(@Path("userId") userId: Long): Single<QuestionListEntity>

    @GET("users/{userId}/favorites?order=desc&sort=votes&site=stackoverflow")
    fun getFavoritesByUser(@Path("userId") userId: Long): Single<QuestionListEntity>

    @GET("users/{userId}/answers?order=desc&sort=votes&site=stackoverflow")
    fun getAnswersByUser(@Path("userId") userId: Long): Single<AnswerListEntity>
}