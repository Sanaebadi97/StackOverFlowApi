package info.sanaebadi.stackoverflowproject.model.user

import info.sanaebadi.stackoverflowproject.model.base.PresentationModel


data class UserPre(
    var userId: Long,
    var displayName: String,
    var reputation: Long,
    var profileImage: String
) : PresentationModel {

    constructor() : this(-1, "", 0, "")
}