package info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.sanaebadi.domain.interactor.base.BaseSingleObserver
import info.sanaebadi.domain.interactor.user.UserUseCase
import info.sanaebadi.domain.model.user.UserListModel
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base.MutableViewModel
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {

    var userList = MutableLiveData<MutableViewModel<UserListModel>>()

    fun getUserList(page: Int) {
        val value = MutableViewModel<UserListModel>()
        value.setLoading(true)
        userList.postValue(value)

        userUseCase.execute(object : BaseSingleObserver<UserListModel>() {
            override fun onSuccess(t: UserListModel) {
                super.onSuccess(t)
                value.setLoading(false)
                value.setThrowable(null)
                value.setData(t)
                userList.postValue(value)

            }

            override fun onError(e: Throwable) {
                super.onError(e)
                value.setLoading(false)
                value.setThrowable(e)
                userList.postValue(value)

            }

        }, page)
    }
}