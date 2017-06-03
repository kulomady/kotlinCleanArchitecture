package com.rnd.madi.myclean.features.users.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rnd.madi.myclean.R
import com.rnd.madi.myclean.base.persentation.view.BaseFragment
import com.rnd.madi.myclean.injection.UserComponent
import kotlinx.android.synthetic.main.fragment_users.*
import javax.inject.Inject



/**
 * @author madi on 6/3/17.
 */
class UsersFragment : BaseFragment(),UsersContract.View {


    @Inject
    lateinit var mPresenter: UsersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getComponent(UserComponent::class.java).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {

        return inflater?.inflate(R.layout.fragment_users,container,false) as View
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.attachView(this)
        mPresenter.requestUserList()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun showProgress() {
        text_view_error_msg.visibility = View.GONE
        progress_bar.visibility = View.VISIBLE

    }

    override fun hideProgress() {
        text_view_error_msg.visibility = View.GONE
        progress_bar.visibility = View.GONE
    }

    override fun getTerm() = "kulomady"


    override fun showError(message: String) {
        showToastMessage(message)
    }

}
