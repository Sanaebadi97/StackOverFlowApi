package info.sanaebadi.domain.interactor.base

import io.reactivex.observers.DisposableCompletableObserver

open class BaseCompeletableObserver : DisposableCompletableObserver(), IObserver {

    override fun onComplete() {

    }

    override fun onError(e: Throwable) {

    }
}
