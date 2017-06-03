package com.rnd.madi.myclean.base.domain.interactor

import com.rnd.madi.myclean.base.domain.executor.PostExecutionThread
import com.rnd.madi.myclean.base.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author madi on 5/29/17.
 */

abstract class UseCase<T, Params> internal constructor(
        private val threadExecutor: ThreadExecutor,
        private val postExecutionThread: PostExecutionThread){

    private val disposables = CompositeDisposable()

    protected abstract fun buildUsecaseObservable(params: Params?): Observable<T>

    open fun execute(observer: DisposableObserver<T>, params: Params?) {
        val observable = buildUsecaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribeWith(observer))
    }

    fun dispose() {
        if (disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
       disposables.add(disposable)
    }


}
