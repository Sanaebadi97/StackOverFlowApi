package info.sanaebadi.repository.dataSource.user

import info.sanaebadi.entity.user.UserListModelEntity
import io.reactivex.Single

interface UserDataSource {
    fun getUsers(page: Int = 1): Single<UserListModelEntity>
}