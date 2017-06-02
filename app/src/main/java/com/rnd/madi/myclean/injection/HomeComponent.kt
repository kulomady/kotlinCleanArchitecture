package com.rnd.madi.myclean.injection

import com.rnd.madi.myclean.base.di.component.ApplicationComponent
import com.rnd.madi.myclean.base.persentation.view.BaseActivity
import com.rnd.madi.myclean.injection.scope.PerActivity
import dagger.Component

/**
 * @author madi on 6/1/17.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(baseActivity: BaseActivity)

}