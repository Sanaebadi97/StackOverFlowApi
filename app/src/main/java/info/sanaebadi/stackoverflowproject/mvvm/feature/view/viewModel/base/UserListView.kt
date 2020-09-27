package info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base

import info.sanaebadi.stackoverflowproject.model.user.UserPresentation

interface UserListView {
    fun showLoading()
    fun hideLoading()
    fun addUsersToList(users: List<UserPresentation>)
    fun showEmptyListError()
    fun hideEmptyListError()
    fun showToastError()
    fun clearList()
}