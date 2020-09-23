package info.sanaebadi.domain.model.user

import info.sanaebadi.domain.model.base.BaseDomainModel


data class User(
    var userId: Long,
    var displayName: String,
    var reputation: Long,
    var profileImage: String
) : BaseDomainModel {

    constructor() : this(-1, "", 0, "")
}