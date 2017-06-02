package com.rnd.madi.myclean.injection

import com.rnd.madi.myclean.base.di.scope.PerActivity
import com.rnd.madi.myclean.data.users.cache.UserCache
import com.rnd.madi.myclean.data.users.cache.UserCacheImpl
import com.rnd.madi.myclean.data.users.network.UserService
import com.rnd.madi.myclean.data.users.network.entity.UserEntityMapper
import com.rnd.madi.myclean.data.users.repository.UserDataRepository
import com.rnd.madi.myclean.data.users.repository.source.UserDatasourceFactory
import com.rnd.madi.myclean.features.users.domain.UserRepository
import com.rnd.madi.myclean.features.users.domain.interactor.GetUsersUsecase
import com.rnd.madi.myclean.features.users.view.UsersPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author madi on 6/1/17.
 */
@Module
class UserModule {

    @Provides
    @PerActivity
    internal fun provideUserRepository(userDatasourceFactory: UserDatasourceFactory,
                                       userEntityMapper: UserEntityMapper): UserRepository {

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
    internal fun provideUserCache():UserCache {
        return UserCacheImpl()
    }

    @Provides
    @PerActivity
    internal fun provideUserService(retrofit: Retrofit) = retrofit.create(UserService::class.java)

    @Provides
    @PerActivity
    internal fun provideUsersPresenter(getUsersUsecase: GetUsersUsecase): UsersPresenter {
        return UsersPresenter(getUsersUsecase)

    }


}