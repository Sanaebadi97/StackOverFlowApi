package info.sanaebadi.domain.interactor.base

import io.reactivex.observers.DisposableMaybeObserver

open class BaseMaybeObserver<T> : DisposableMaybeObserver<T>(), IObserver {

    override fun onSuccess(t: T) {

    }

    override fun onError(e: Throwable) {

    }

    override fun onComplete() {

    }
}
