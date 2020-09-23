package info.sanaebadi.domain.interactor.base

import io.reactivex.observers.DisposableSingleObserver

open class BaseSingleObserver<T> : DisposableSingleObserver<T>(), IObserver {

    override fun onSuccess(t: T) {
    }

    override fun onError(e: Throwable) {
    }
}
