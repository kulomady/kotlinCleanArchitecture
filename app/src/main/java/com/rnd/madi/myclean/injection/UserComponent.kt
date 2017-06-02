package com.rnd.madi.myclean.injection

import com.rnd.madi.myclean.base.di.component.ApplicationComponent
import com.rnd.madi.myclean.base.di.module.ActivityModule
import com.rnd.madi.myclean.base.di.scope.PerActivity
import com.rnd.madi.myclean.features.users.view.UsersFragment
import dagger.Component

/**
 * @author madi on 6/1/17.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class, UserModule::class))
interface UserComponent {
    fun inject(usersFragment: UsersFragment)

}