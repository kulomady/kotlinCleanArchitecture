package com.rnd.madi.myclean

import android.app.Application
import com.rnd.madi.myclean.base.common.Constants
import com.rnd.madi.myclean.base.di.component.ApplicationComponent
import com.rnd.madi.myclean.base.di.component.DaggerApplicationComponent
import com.rnd.madi.myclean.base.di.module.ApplicationModule
import com.rnd.madi.myclean.base.di.module.NetworkModule
import com.squareup.leakcanary.LeakCanary


/**
 * @author madi on 5/31/17.
 */

class MyCleanApp : Application() {

    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initialInjector()
        initialLeackDetection()
    }

    private fun initialInjector() {
        appComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule(Constants.API.BASE_URL))
                .build()
    }

    private fun initialLeackDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
        }
    }

}