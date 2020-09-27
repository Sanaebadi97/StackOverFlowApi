package info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base


open class MutableViewModel<T> {
    private var loading = true
    private var data: T? = null
        private set
    private var throwable: Throwable? = null

    constructor(loading: Boolean, data: T?, throwable: Throwable?) {
        this.loading = loading
        this.data = data
        this.throwable = throwable
    }

    constructor() {}

    open fun isLoading(): Boolean {
        return loading
    }

    open fun setLoading(loading: Boolean) {
        this.loading = loading
    }

    fun setData(data: T?) {
        this.data = data
    }

    fun getData(): T? {
        return data
    }

    open fun getThrowable(): Throwable? {
        return throwable
    }

    open fun setThrowable(throwable: Throwable?) {
        this.throwable = throwable
    }
}
