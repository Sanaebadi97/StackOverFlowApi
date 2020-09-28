package info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base

import info.sanaebadi.domain.model.UserDetailsModel


interface DetailView {
    fun showDetails(details: UserDetailsModel)
    fun showError(error: String)
    fun showLoading()
    fun hideLoading()
}