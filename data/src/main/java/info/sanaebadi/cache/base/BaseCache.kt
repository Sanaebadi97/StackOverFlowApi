package info.sanaebadi.cache.base

import io.reactivex.Completable
import io.reactivex.Maybe

interface BaseCache<T> {

    fun saveData(item: T)
    fun getData(key: String): Maybe<T>
    fun isCached(key: String): Boolean
    fun deleteCache(): Completable


}