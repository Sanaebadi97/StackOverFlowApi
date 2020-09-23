package info.sanaebadi.mapper.user

import info.sanaebadi.domain.model.user.User
import info.sanaebadi.domain.model.user.UserListModel
import info.sanaebadi.entity.user.UserEntity
import info.sanaebadi.entity.user.UserListModelEntity
import info.sanaebadi.mapper.base.DataLayerMapper
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserMapper @Inject constructor() : DataLayerMapper<UserEntity, User> {

    fun toDomain(userListModelEntity: UserListModelEntity): UserListModel? {
        val userList: MutableList<User> = ArrayList<User>()

        for (user in userListModelEntity.items) {
            toDomain(user)?.let { userList.add(it) }
        }
        return UserListModel(userList)
    }


    override fun toDomain(e: UserEntity?): User? {
        return e?.userId?.let {
            User(
                it,
                e.displayName,
                e.reputation,
                e.profileImage
            )
        }
    }

    override fun toEntity(d: User?): UserEntity? {
        return null
    }


}