package com.rnd.madi.myclean.base.di.module

import android.app.Application
import android.content.Context
import com.rnd.madi.myclean.base.jobExecutor.JobExecutor
import com.rnd.madi.myclean.base.domain.executor.PostExecutionThread
import com.rnd.madi.myclean.base.domain.executor.ThreadExecutor
import com.rnd.madi.myclean.base.persentation.executor.UiThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author madi on 5/30/17.
 */

@Module
class ApplicationModule(private val mApplication: Application){

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return mApplication.applicationContext
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApplication
    }
    @Provides
    @Singleton
    fun provideThreadExecutor(): ThreadExecutor {
        return JobExecutor()
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(): PostExecutionThread {
        return UiThread()
    }
}