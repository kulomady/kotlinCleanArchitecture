package com.rnd.madi.myclean.base.persentation.view

import android.app.Fragment
import android.widget.Toast
import com.rnd.madi.myclean.base.di.HasComponent



/**
 * @author madi on 6/1/17.
 */
abstract class BaseFragment: Fragment() {

    protected fun showToastMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }


    protected fun <C> getComponent(componentType: Class<C>): C {
        return componentType.cast((activity as HasComponent<*>).component)
    }
}