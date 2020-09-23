package info.sanaebadi.repository.dataSourceImpl

import info.sanaebadi.entity.user.UserListModel
import info.sanaebadi.networking.base.AbstractService
import info.sanaebadi.networking.retrofit.UserApiRetrofitService
import info.sanaebadi.repository.dataSource.user.UserDataSource
import io.reactivex.Single

class UserOnlineDataSource  : AbstractService<UserApiRetrofitService>(UserApiRetrofitService::class.java), UserDataSource {

    override fun getUsers(page: Int, forced: Boolean): Single<UserListModel> {
      return service.getUsers(page)
    }

}