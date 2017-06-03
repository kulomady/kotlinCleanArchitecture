package com.rnd.madi.myclean.base.persentation.presenter

import com.rnd.madi.myclean.base.domain.interactor.UseCase
import com.rnd.madi.myclean.base.persentation.view.CleanView

/**
 * @author madi on 5/29/17.
 */

open class BasePresenter<V: CleanView>(vararg useCases: UseCase<*,*> ) : CleanPresenter<V> {

    private var view: V ? = null
    private val useCasesList: List<UseCase<*, *>> = ArrayList()

    init {
        for (userCase in useCases) {
            useCasesList.plus(userCase)
        }
    }

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
        for (userCase in useCasesList) {
            userCase.dispose()
        }
    }

    protected fun getView(): V {
        if (view == null) {
            throw RuntimeException("Please call BasePresenter.attachView(CleanView) before " +
                    "requesting data to the presenter")
        } else {
            return view as V
        }
    }
}