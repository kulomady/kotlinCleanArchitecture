package com.rnd.madi.myclean.base.di.module

import android.app.Application
import android.content.Context
import com.rnd.madi.myclean.base.data.JobExecutor
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
class ApplicationModule(private val application: Application){

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideThreadExecutor(): ThreadExecutor {
        return JobExecutor()
    }

    @Provides
    @Singleton
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }
}