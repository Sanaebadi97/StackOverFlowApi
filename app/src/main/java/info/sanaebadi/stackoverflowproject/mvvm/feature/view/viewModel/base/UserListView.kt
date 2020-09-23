package info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base

import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.UserViewModel

interface UserListView {
    fun showLoading()
    fun hideLoading()
    fun addUsersToList(users: List<UserViewModel>)
    fun showEmptyListError()
    fun hideEmptyListError()
    fun showToastError()
    fun clearList()
}