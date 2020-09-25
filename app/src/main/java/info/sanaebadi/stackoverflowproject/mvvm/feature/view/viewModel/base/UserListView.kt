package info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base

import info.sanaebadi.stackoverflowproject.model.user.UserListModelPre

interface UserListView {
    fun showLoading()
    fun hideLoading()
    fun addUsersToList(users: List<UserListModelPre>)
    fun showEmptyListError()
    fun hideEmptyListError()
    fun showToastError()
    fun clearList()
}