package com.rnd.madi.myclean.features.users.domain

import com.rnd.madi.myclean.features.users.domain.model.User
import io.reactivex.Observable

/**
 * @author madi on 5/31/17.
 */

interface UserRepository {
    fun getUserlist(searchTerm: String) : Observable<List<User>>
}