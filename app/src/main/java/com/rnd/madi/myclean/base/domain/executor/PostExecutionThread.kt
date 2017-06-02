package com.rnd.madi.myclean.base.domain.executor

import io.reactivex.Scheduler


/**
 * @author madi on 5/29/17.
 */

interface PostExecutionThread {
    val scheduler: Scheduler
}