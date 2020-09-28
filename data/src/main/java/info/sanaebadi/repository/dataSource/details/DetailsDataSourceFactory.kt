package info.sanaebadi.repository.dataSource.details

import info.sanaebadi.domain.repository.CacheStrategy
import info.sanaebadi.repository.dataSource.base.BaseDataSourceFactory
import info.sanaebadi.repository.dataSource.user.UserDataSource
import info.sanaebadi.repository.dataSourceImpl.UserOnlineDataSource
import io.reactivex.Completable
import javax.inject.Inject

class DetailsDataSourceFactory @Inject constructor() : BaseDataSourceFactory<UserDataSource> {
    override fun create(cacheStrategy: CacheStrategy?, vararg params: String?): UserDataSource {
        return UserOnlineDataSource()
    }

    override fun deleteCache(): Completable? {
        return null
    }
}