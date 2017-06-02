package com.rnd.madi.myclean.base.di.component

import android.app.Application
import android.content.Context
import com.rnd.madi.myclean.base.di.module.ApplicationModule
import com.rnd.madi.myclean.base.di.module.NetworkModule
import com.rnd.madi.myclean.base.domain.executor.PostExecutionThread
import com.rnd.madi.myclean.base.domain.executor.ThreadExecutor
import com.rnd.madi.myclean.base.persentation.view.BaseActivity
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author madi on 5/31/17.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class))
interface ApplicationComponent {

    fun inject(baseActivity: BaseActivity)

    fun application(): Application

    fun context(): Context

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    fun retrofit(): Retrofit

}