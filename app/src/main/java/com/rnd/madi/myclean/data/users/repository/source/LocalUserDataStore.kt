package com.rnd.madi.myclean.data.users.repository.source

import com.rnd.madi.myclean.data.users.cache.UserCache
import com.rnd.madi.myclean.data.users.network.entity.UserEntity
import com.rnd.madi.myclean.data.users.network.UserService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author madi on 5/31/17.
 */

class LocalUserDataStore @Inject constructor(private val userService: UserService,
                                             private val userCache: UserCache) : UserDataSource {

    override fun userEntityList(searchTerm: String): Observable<List<UserEntity>> {
        TODO("not implemented")
    }


    override fun userEntitiesById(username: String): Observable<UserEntity> {
        TODO("not implemented")
    }

}