package com.rnd.madi.myclean.base.persentation.view

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import com.rnd.madi.myclean.MyCleanApp
import com.rnd.madi.myclean.base.di.component.ApplicationComponent


/**
 * @author madi on 6/1/17.
 */
abstract class BaseActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applicationComponent().inject(this)
    }

    protected fun addFragment(containerId: Int, fragment: Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(containerId, fragment)
        fragmentTransaction.commit()
    }

    protected fun applicationComponent(): ApplicationComponent {
        return MyCleanApp.appComponent
    }
}