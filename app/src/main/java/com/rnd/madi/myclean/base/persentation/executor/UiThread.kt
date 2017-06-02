package com.rnd.madi.myclean.base.persentation.executor

import com.rnd.madi.myclean.base.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * @author madi on 5/29/17.
 */

class UiThread @Inject
internal constructor() : PostExecutionThread {

    override val scheduler: Scheduler = AndroidSchedulers.mainThread()
}