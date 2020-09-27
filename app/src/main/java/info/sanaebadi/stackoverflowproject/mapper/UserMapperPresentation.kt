package info.sanaebadi.stackoverflowproject.mapper

import info.sanaebadi.domain.model.user.User
import info.sanaebadi.domain.model.user.UserListModel
import info.sanaebadi.stackoverflowproject.mapper.base.PresentationLayerMapper
import info.sanaebadi.stackoverflowproject.model.user.UserListModelPresentation
import info.sanaebadi.stackoverflowproject.model.user.UserPresentation
import java.util.*
import javax.inject.Inject

class UserMapperPresentation @Inject constructor() :
    PresentationLayerMapper<UserPresentation, User> {

    override fun toDomain(p: UserPresentation?): User? {
        return null
    }

    override fun toPresentation(d: User?): UserPresentation {
        return UserPresentation(d?.userId!!, d.displayName, d.reputation, d.profileImage)
    }

    fun toPresentation(userListModel: UserListModel): UserListModelPresentation {
        val itemPresentationList: MutableList<UserPresentation> = ArrayList<UserPresentation>()

        for (user: User in userListModel.items) {
            itemPresentationList.add(toPresentation(user))
        }

        return UserListModelPresentation(itemPresentationList)
    }

}