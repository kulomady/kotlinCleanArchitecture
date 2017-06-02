package com.rnd.madi.myclean.base.persentation.presenter

import com.rnd.madi.myclean.base.persentation.view.CleanView

/**
 * @author madi on 6/1/17.
 */
interface CleanPresenter <V: CleanView>{

    fun attachView(view: V)

    fun detachView()
}