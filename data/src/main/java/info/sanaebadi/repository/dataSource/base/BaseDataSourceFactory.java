package info.sanaebadi.repository.dataSource.base;

import info.sanaebadi.domain.repository.CacheStrategy;
import io.reactivex.Completable;

public interface BaseDataSourceFactory<T> {
    T create(CacheStrategy cacheStrategy, String... params);

    Completable deleteCache();
}
