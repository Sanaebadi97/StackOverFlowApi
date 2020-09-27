package info.sanaebadi.domain.repository

import info.sanaebadi.domain.model.user.UserListModel
import io.reactivex.Single

interface UserRepository {
    fun getUsers(page: Int): Single<UserListModel>
}