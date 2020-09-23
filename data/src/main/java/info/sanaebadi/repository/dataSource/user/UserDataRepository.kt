package info.sanaebadi.repository.dataSource.user

import javax.inject.Inject

class UserDataRepository @Inject constructor(
    private val userDataSourceFactory: UserDataSourceFactory
)