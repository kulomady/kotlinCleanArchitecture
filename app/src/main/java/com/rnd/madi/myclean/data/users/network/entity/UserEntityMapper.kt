package com.rnd.madi.myclean.data.users.network.entity

import com.rnd.madi.myclean.base.di.scope.PerActivity
import com.rnd.madi.myclean.features.users.domain.model.User
import javax.inject.Inject


/**
 * @author madi on 5/31/17.
 */

@PerActivity
class UserEntityMapper @Inject constructor() {

    fun transform(userEntity: UserEntity?)
            = User(userEntity?.name as String, userEntity.photoUrls as String)

    fun transform(userEntityCollection: Collection<UserEntity>)
            = userEntityCollection.mapTo(ArrayList<User>(20)) { transform(it) }
}