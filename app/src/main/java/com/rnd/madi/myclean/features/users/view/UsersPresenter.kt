package com.rnd.madi.myclean.features.users.view

import android.util.Log
import com.rnd.madi.myclean.base.di.scope.PerActivity
import com.rnd.madi.myclean.base.persentation.presenter.BasePresenter
import com.rnd.madi.myclean.features.users.domain.interactor.GetUsersUsecase
import javax.inject.Inject

/**
 * @author madi on 6/1/17.
 */
@PerActivity
class UsersPresenter @Inject constructor(getUsersUsecase: GetUsersUsecase)
    : BasePresenter<UsersContract.View>(getUsersUsecase) , UsersContract.Presenter {

    private val TAG = "UsersPresenter"

    override fun requestUserList() {
        Log.d(TAG, "request list")
    }

}