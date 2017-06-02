package com.rnd.madi.myclean.base.di.component

import android.app.Activity
import com.rnd.madi.myclean.base.di.module.ActivityModule
import com.rnd.madi.myclean.base.di.scope.PerActivity
import dagger.Component

/**
 * @author madi on 6/3/17.
 */
@PerActivity
@Component(
        dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    //Exposed to sub-graphs.
    fun activity(): Activity
}