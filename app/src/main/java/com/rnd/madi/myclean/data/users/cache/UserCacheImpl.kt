package com.rnd.madi.myclean.data.users.cache

import com.rnd.madi.myclean.data.users.network.entity.UserEntity
import io.reactivex.Observable

/**
 * @author madi on 5/31/17.
 */

class UserCacheImpl() : UserCache {
    override fun get(userId: Int): Observable<UserEntity> {
        TODO("not implemented yet")
    }

    override fun put(userEntity: UserEntity) {
        TODO("not implemented yet")
    }

    override fun isCached(userId: Int): Boolean {
        TODO("not implemented yet")
    }

    override fun getAll(): Observable<List<UserEntity>> {
        TODO("not implemented yet")
    }

}