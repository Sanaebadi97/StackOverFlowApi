package info.sanaebadi.stackoverflowproject.mapper

import info.sanaebadi.domain.model.user.User
import info.sanaebadi.domain.model.user.UserListModel
import info.sanaebadi.stackoverflowproject.mapper.base.PresentationLayerMapper
import info.sanaebadi.stackoverflowproject.model.user.UserListModelPre
import info.sanaebadi.stackoverflowproject.model.user.UserPre
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPresentationMapper @Inject constructor() : PresentationLayerMapper<UserPre, User> {

    override fun toDomain(p: UserPre?): User? {
        return null
    }

    override fun toPresentation(d: User?): UserPre? {
        return d?.userId?.let { UserPre(it, d.displayName, d.reputation, d.profileImage) }
    }

    fun mtoPresentation(userListModel: UserListModel): UserListModelPre {
        val userlist: MutableList<UserPre> = ArrayList<UserPre>()

        for (user: User in userListModel.items) {
            toPresentation(user)?.let { userlist.add(it) }
        }
        return UserListModelPre(userlist)
    }
}