package info.sanaebadi.domain.model.user

import info.sanaebadi.domain.model.base.BaseDomainModel


data class Owner(var userId: Long) : BaseDomainModel {

    constructor() : this(-1)
}