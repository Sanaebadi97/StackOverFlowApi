package info.sanaebadi.domain.interactor.base

import com.fernandocejas.arrow.checks.Preconditions
import info.sanaebadi.domain.executor.PostExecutionThread
import info.sanaebadi.domain.executor.ThreadExecutor
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase<Params>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : IUseCase<DisposableCompletableObserver, Params> {
    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun execute(observer: DisposableCompletableObserver, params: Params) {
        Preconditions.checkNotNull(observer)
        val completable = this.buildUseCaseCompletable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
        addDisposable(completable.subscribeWith(observer))
    }


    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    abstract fun buildUseCaseCompletable(params: Params): Completable


    private fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }
}


