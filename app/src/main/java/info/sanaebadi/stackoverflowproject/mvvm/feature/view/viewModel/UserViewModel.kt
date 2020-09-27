package info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.sanaebadi.domain.interactor.base.BaseSingleObserver
import info.sanaebadi.domain.interactor.user.UserUseCase
import info.sanaebadi.domain.model.user.UserListModel
import info.sanaebadi.stackoverflowproject.mapper.UserMapperPresentation
import info.sanaebadi.stackoverflowproject.model.user.UserListModelPresentation
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base.MutableViewModel
import javax.inject.Inject

private const val INFINITE_LOADING_OFFSET = 5

class UserViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
    private val mapper: UserMapperPresentation
) : ViewModel() {

    var userList = MutableLiveData<MutableViewModel<UserListModelPresentation>>()

    fun getUserList(page: Int = 1) {
        val value = MutableViewModel<UserListModelPresentation>()
        value.setLoading(true)
        userList.postValue(value)

        userUseCase.execute(object : BaseSingleObserver<UserListModel>() {
            override fun onSuccess(t: UserListModel) {
                super.onSuccess(t)
                value.setLoading(false)
                value.setThrowable(null)
                value.setData(mapper.toPresentation(t))
                userList.postValue(value)

            }

            override fun onError(e: Throwable) {
                super.onError(e)
                value.setLoading(false)
                value.setThrowable(e)
                value.setData(null)
                userList.postValue(value)

            }

        }, page)
    }

    fun onScrollChanged(lastVisibleItemPosition: Int, totalItemCount: Int) {
            if (lastVisibleItemPosition >= totalItemCount - INFINITE_LOADING_OFFSET) {
                getUserList()
            }

    }
}