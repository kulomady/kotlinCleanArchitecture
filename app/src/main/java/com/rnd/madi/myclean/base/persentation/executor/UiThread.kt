package com.rnd.madi.myclean.base.persentation.executor

import com.rnd.madi.myclean.base.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author madi on 5/29/17.
 */

@Singleton
class UiThread @Inject constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}