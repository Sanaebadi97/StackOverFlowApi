package info.sanaebadi.domain.interactor.base

import com.fernandocejas.arrow.checks.Preconditions
import info.sanaebadi.domain.executor.PostExecutionThread
import info.sanaebadi.domain.executor.ThreadExecutor
import io.reactivex.Maybe
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableMaybeObserver
import io.reactivex.schedulers.Schedulers

abstract class MaybeUseCase<T, Params>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) :
    IUseCase<DisposableMaybeObserver<T>, Params> {
    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun execute(observer: DisposableMaybeObserver<T>, params: Params) {
        val maybe = this.buildUseCaseMaybe(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
        addDisposable(maybe.subscribeWith(observer) as Disposable)
    }


    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    abstract fun buildUseCaseMaybe(params: Params): Maybe<T>

    private fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }
}
