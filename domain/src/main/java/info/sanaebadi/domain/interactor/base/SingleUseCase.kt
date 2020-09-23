package info.sanaebadi.domain.interactor.base

import com.fernandocejas.arrow.checks.Preconditions
import info.sanaebadi.domain.executor.PostExecutionThread
import info.sanaebadi.domain.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, Params>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : IUseCase<DisposableSingleObserver<T>, Params> {
    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun execute(observer: DisposableSingleObserver<T>, params: Params) {
        Preconditions.checkNotNull(observer)
        val single = this.buildUseCaseSingle(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
        addDisposable(single.subscribeWith(observer))
    }


    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    abstract fun buildUseCaseSingle(params: Params): Single<T>

    private fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }
}
