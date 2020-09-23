package info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base

import info.sanaebadi.domain.model.user.User

interface UserListView {
    fun showLoading()
    fun hideLoading()
    fun addUsersToList(users: List<User>)
    fun showEmptyListError()
    fun hideEmptyListError()
    fun showToastError()
    fun clearList()
}