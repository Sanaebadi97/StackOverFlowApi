package info.sanaebadi.domain.interactor.base

interface IUseCase<T, Params> {
        fun execute(observer: T, params: Params)
}
