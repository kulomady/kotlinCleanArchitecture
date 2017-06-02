package com.rnd.madi.myclean.features.users.view

import android.os.Bundle
import com.rnd.madi.myclean.R
import com.rnd.madi.myclean.base.di.HasComponent
import com.rnd.madi.myclean.base.persentation.view.BaseActivity
import com.rnd.madi.myclean.injection.DaggerUserComponent
import com.rnd.madi.myclean.injection.UserComponent

class UsersActivity : BaseActivity(), HasComponent<UserComponent> {
    lateinit var userComponent: UserComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        initInjector()
        addFragment(R.id.fragmentContainer, UsersFragment())
    }

    override val component: UserComponent
        get() = userComponent

    private fun initInjector() {
        userComponent = DaggerUserComponent.builder()
                .applicationComponent(applicationComponent())
                .activityModule(activityModule())
                .build()
    }
}
