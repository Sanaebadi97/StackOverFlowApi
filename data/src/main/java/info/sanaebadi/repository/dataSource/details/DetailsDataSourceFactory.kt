package info.sanaebadi.repository.dataSource.details

import info.sanaebadi.domain.repository.CacheStrategy
import info.sanaebadi.repository.dataSource.base.BaseDataSourceFactory
import info.sanaebadi.repository.dataSourceImpl.DetailsOnlineDataSource
import io.reactivex.Completable
import javax.inject.Inject

class DetailsDataSourceFactory @Inject constructor() : BaseDataSourceFactory<DetailsDataSource> {
    override fun create(cacheStrategy: CacheStrategy?, vararg params: String?): DetailsDataSource {
        return DetailsOnlineDataSource()
    }

    override fun deleteCache(): Completable? {
        return null
    }
}