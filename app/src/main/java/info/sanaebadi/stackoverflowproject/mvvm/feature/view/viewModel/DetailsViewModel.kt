package info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel

import android.annotation.SuppressLint
import info.sanaebadi.domain.interactor.user.DetailsUseCase
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base.BasePresenter
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base.DetailView
import info.sanaebadi.stackoverflowproject.util.SchedulerProvider
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val detailsUseCase: DetailsUseCase,
    private val schedulerProvider: SchedulerProvider
) : BasePresenter<DetailView>() {

    @SuppressLint("CheckResult")
    fun getDetails(id: Long) {
        view?.showLoading()
        detailsUseCase.execute(id)
            .subscribeOn(schedulerProvider.ioScheduler())
            .observeOn(schedulerProvider.uiScheduler())
            .subscribe({ placeData ->
                view?.hideLoading()
                view?.showDetails(placeData)
            },
                { error ->
                    view?.hideLoading()
                    view?.showError(error.localizedMessage!!)
                })
    }
}
