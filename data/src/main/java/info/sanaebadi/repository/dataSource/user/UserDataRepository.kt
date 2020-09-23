package info.sanaebadi.repository.dataSource.user

import info.sanaebadi.domain.model.user.UserListModel
import info.sanaebadi.domain.repository.CacheStrategy
import info.sanaebadi.domain.repository.UserRepository
import info.sanaebadi.mapper.user.UserMapper
import io.reactivex.Single
import javax.inject.Inject

class UserDataRepository @Inject constructor(
    private val userDataSourceFactory: UserDataSourceFactory,
    private val userMapper: UserMapper
) : UserRepository {

    override fun getUsers(page: Int): Single<UserListModel> {
        return userDataSourceFactory.create(CacheStrategy.ONLINE_FIRST).getUsers(page)
            .map { data -> userMapper.toDomain(data) }
    }
}