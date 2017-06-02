package com.rnd.madi.myclean.injection

import com.rnd.madi.myclean.data.users.cache.UserCache
import com.rnd.madi.myclean.data.users.cache.UserCacheImpl
import com.rnd.madi.myclean.data.users.network.entity.UserEntityMapper
import com.rnd.madi.myclean.data.users.network.UserService
import com.rnd.madi.myclean.data.users.repository.UserDataRepository
import com.rnd.madi.myclean.data.users.repository.source.UserDatasourceFactory
import com.rnd.madi.myclean.injection.scope.PerActivity
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author madi on 6/1/17.
 */
@Module
class HomeModule {

    @Provides
    @PerActivity
    internal fun provideUserRepository(userDatasourceFactory: UserDatasourceFactory,
                                       userEntityMapper: UserEntityMapper): UserDataRepository {

           return UserDataRepository(userDatasourceFactory,userEntityMapper)
    }

    @Provides
    @PerActivity
    internal fun provideUserSourceFactory(userService: UserService,
                                          userCache: UserCache): UserDatasourceFactory {

        return UserDatasourceFactory(userService,userCache)
    }

    @Provides
    @PerActivity
    internal fun provideUserCache() = UserCacheImpl()

    @Provides
    @PerActivity
    internal fun provideUserService(retrofit: Retrofit) = retrofit.create(UserService::class.java)

}