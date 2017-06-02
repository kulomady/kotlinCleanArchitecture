package com.rnd.madi.myclean.data.users.cache

import com.rnd.madi.myclean.data.users.network.entity.UserEntity
import io.reactivex.Observable


/**
 * @author madi on 5/31/17.
 */
interface UserCache {

    fun get(userId: Int): Observable<UserEntity>

    fun put(userEntity: UserEntity)

    fun isCached(userId: Int): Boolean

    fun getAll(): Observable<List<UserEntity>>
}