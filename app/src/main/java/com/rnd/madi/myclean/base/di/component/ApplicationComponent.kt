package com.rnd.madi.myclean.base.di.component

import android.app.Application
import com.rnd.madi.myclean.base.di.module.ApplicationModule
import com.rnd.madi.myclean.base.di.module.NetworkModule
import com.rnd.madi.myclean.base.domain.executor.PostExecutionThread
import com.rnd.madi.myclean.base.domain.executor.ThreadExecutor
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author madi on 5/31/17.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class))
interface ApplicationComponent {

    fun application(): Application

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    fun retrofit(): Retrofit

}