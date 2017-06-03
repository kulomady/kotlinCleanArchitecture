package com.rnd.madi.myclean.data.users.repository.source

import android.util.Log
import com.rnd.madi.myclean.data.users.cache.UserCache
import com.rnd.madi.myclean.data.users.network.UserService
import com.rnd.madi.myclean.data.users.network.entity.UserEntity
import com.rnd.madi.myclean.data.users.network.entity.UserListEntity
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author madi on 5/31/17.
 */

class CloudUserDataStore @Inject constructor(
        private val userService: UserService, private val userCache: UserCache) : UserDataSource {

    override fun userEntityList(searchTerm: String): Observable<UserListEntity>{
        return userService.searchGithubUsers(searchTerm)
    }


    override fun userEntitiesById(username: String): Observable<UserEntity> {
        return userService.getUser(username).doOnNext {result-> saveTocache(result) }
    }

    private fun saveTocache(result: UserEntity) {
        Log.d("CloudUserDataStore", "result $result")
    }

}