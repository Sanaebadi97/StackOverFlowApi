package info.sanaebadi.domain.repository

import info.sanaebadi.domain.model.user.UserListModel
import io.reactivex.Single

interface UserRepository {
    fun getUsers(page: Int = 1, forced: Boolean = false): Single<UserListModel>
}