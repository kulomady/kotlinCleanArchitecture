package com.rnd.madi.myclean.data.users.repository

import com.rnd.madi.myclean.data.users.network.entity.UserEntityMapper
import com.rnd.madi.myclean.data.users.repository.source.UserDatasourceFactory
import com.rnd.madi.myclean.features.users.domain.UserRepository
import com.rnd.madi.myclean.features.users.domain.model.User
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author madi on 5/31/17.
 */

@Singleton
class UserDataRepository @Inject constructor(
        private val userDataSourceFactory: UserDatasourceFactory,
        private val userEntityMapper: UserEntityMapper) : UserRepository {


    override fun getUserlist(searchTerm: String): Observable<List<User>> = userDataSourceFactory
            .createUserDataSource().userEntityList(searchTerm)
                .map {results -> userEntityMapper.transform(results) }


}