package com.rnd.madi.myclean.features.users.view

import com.rnd.madi.myclean.base.persentation.presenter.CleanPresenter
import com.rnd.madi.myclean.base.persentation.view.CleanView

/**
 * @author madi on 6/1/17.
 */
interface UsersContract {

    interface View : CleanView {

        fun showProgress()

        fun hideProgress()

        fun getTerm():String

        fun showError(message: String)
    }

    interface Presenter : CleanPresenter<View> {

        fun requestUserList()
    }
}