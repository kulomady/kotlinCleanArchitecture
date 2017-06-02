package com.rnd.madi.myclean.data.users.repository.source

import com.rnd.madi.myclean.data.users.network.entity.UserEntity
import io.reactivex.Observable

/**
 * @author madi on 5/31/17.
 */

interface UserDataSource {

    fun userEntityList(searchTerm: String) : Observable<List<UserEntity>>

    fun userEntitiesById(username: String): Observable<UserEntity>
}