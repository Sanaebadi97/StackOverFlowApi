package info.sanaebadi.repository.dataSource.user

import info.sanaebadi.entity.user.UserListModel
import io.reactivex.Single

interface UserDataSource {
    fun getUsers(page: Int = 1, forced: Boolean = false): Single<UserListModel>
}