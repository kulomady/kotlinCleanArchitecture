package com.rnd.madi.myclean.data.users.network

import com.rnd.madi.myclean.data.users.network.entity.UserEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * @author madi on 5/31/17.
 */

interface UserService {
    @GET("/search/users?per_page=2")
    fun searchGithubUsers(@Query("q") searchTerm: String): Observable<List<UserEntity>>

    @GET("/users/{username}")
    fun getUser(@Path("username") username: String): Observable<UserEntity>
}