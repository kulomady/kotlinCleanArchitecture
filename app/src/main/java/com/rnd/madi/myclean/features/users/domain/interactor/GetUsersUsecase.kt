package com.rnd.madi.myclean.features.users.domain.interactor

import com.rnd.madi.myclean.base.domain.executor.PostExecutionThread
import com.rnd.madi.myclean.base.domain.executor.ThreadExecutor
import com.rnd.madi.myclean.base.domain.interactor.UseCase
import com.rnd.madi.myclean.features.users.domain.UserRepository
import com.rnd.madi.myclean.features.users.domain.model.User
import com.rnd.madi.myclean.base.di.scope.PerActivity
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author madi on 5/31/17.
 */

@PerActivity
class GetUsersUsecase @Inject constructor(private val userRepository: UserRepository,
                                          threadExecutor: ThreadExecutor,
                                          postExecutionThread: PostExecutionThread) :
        UseCase<List<User>, String>(threadExecutor, postExecutionThread) {

    override fun buildUsecaseObservable(params: String?): Observable<List<User>> {
        return when(params) {
            null -> Observable.error(Throwable("params cannot be null"))
            else -> userRepository.getUserlist(params)
        }
    }

}