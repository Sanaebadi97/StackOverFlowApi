package info.sanaebadi.domain.interactor.user

import info.sanaebadi.domain.executor.PostExecutionThread
import info.sanaebadi.domain.executor.ThreadExecutor
import info.sanaebadi.domain.interactor.base.SingleUseCase
import info.sanaebadi.domain.model.user.UserListModel
import info.sanaebadi.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val userRepository: UserRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
) :
    SingleUseCase<UserListModel, Int>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(page: Int): Single<UserListModel> {
        return userRepository.getUsers(page)
    }
}