package info.sanaebadi.entity.base

import info.sanaebadi.data.entity.base.BaseEntity


abstract class ListBaseEntity<T : BaseEntity> : BaseEntity {

    open var list: List<T> = emptyList()
}