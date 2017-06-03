package com.rnd.madi.myclean.features.users.view

import android.util.Log
import com.rnd.madi.myclean.base.di.scope.PerActivity
import com.rnd.madi.myclean.base.persentation.presenter.BasePresenter
import com.rnd.madi.myclean.features.users.domain.interactor.GetUsersUsecase
import com.rnd.madi.myclean.features.users.domain.model.User
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * @author madi on 6/1/17.
 */
@PerActivity
class UsersPresenter @Inject constructor(private val getUsersUsecase: GetUsersUsecase)
    : BasePresenter<UsersContract.View>(getUsersUsecase) , UsersContract.Presenter {

    private val TAG = "UsersPresenter"

    override fun requestUserList() {
        getView().showProgress()
        getUsersUsecase.execute(SearchUserSubcriber(),getView().getTerm())

    }

    private inner class SearchUserSubcriber : DisposableObserver<List<User>>() {
        override fun onComplete() {

        }

        override fun onError(e: Throwable?) {
            Log.d(TAG,e.toString())
            getView().hideProgress()
            getView().showError(e.toString())
        }

        override fun onNext(userList: List<User>?) {
            getView().hideProgress()
            Log.d(TAG, userList.toString())

        }

    }

}



