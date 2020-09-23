package info.sanaebadi.domain.interactor.user

import info.sanaebadi.domain.executor.PostExecutionThread
import info.sanaebadi.domain.executor.ThreadExecutor
import info.sanaebadi.domain.interactor.base.SingleUseCase
import info.sanaebadi.domain.model.user.User
import info.sanaebadi.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val userRepository: UserRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
) :
    SingleUseCase<User, Int>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(params: Int): Single<User> {
        return userRepository.getUsers(params)
    }
}