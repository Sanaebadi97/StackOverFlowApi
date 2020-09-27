package info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base

import info.sanaebadi.stackoverflowproject.model.user.UserListModelPresentation

interface UserListView {
    fun showLoading()
    fun hideLoading()
    fun addUsersToList(users: List<UserListModelPresentation>)
    fun showEmptyListError()
    fun hideEmptyListError()
    fun showToastError()
    fun clearList()
}