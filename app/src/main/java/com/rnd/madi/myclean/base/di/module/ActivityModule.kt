package com.rnd.madi.myclean.base.di.module

import android.app.Activity
import com.rnd.madi.myclean.base.di.scope.PerActivity
import dagger.Module
import dagger.Provides

/**
 * @author madi on 6/3/17.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @PerActivity
    @Provides
    fun provideActivity() = activity

}