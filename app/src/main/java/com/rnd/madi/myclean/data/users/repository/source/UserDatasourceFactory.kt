package com.rnd.madi.myclean.data.users.repository.source

import com.rnd.madi.myclean.data.users.cache.UserCache
import com.rnd.madi.myclean.data.users.network.UserService
import javax.inject.Inject

/**
 * @author madi on 5/31/17.
 */

class UserDatasourceFactory @Inject constructor(
        private val userService: UserService, private val userCache: UserCache) {

    // implementent in here! if any condition like decide source from cloud or cache
    // this case I only request from cloud
    fun createUserDataSource() = CloudUserDataStore(userService, userCache)

}