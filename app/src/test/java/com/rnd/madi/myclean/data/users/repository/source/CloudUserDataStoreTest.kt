package com.rnd.madi.myclean.data.users.repository.source

import com.rnd.madi.myclean.data.users.cache.UserCacheImpl
import com.rnd.madi.myclean.data.users.network.UserService
import com.rnd.madi.myclean.data.users.network.entity.UserEntity
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * @author madi on 6/3/17.
 */
class CloudUserDataStoreTest {

    lateinit var cloudeUserDataStore: CloudUserDataStore

    @Mock lateinit var userUservice: UserService
    @Mock lateinit var userCache: UserCacheImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        cloudeUserDataStore = CloudUserDataStore(userUservice,userCache)
    }

    @Test
    fun shouldCall_UserServiceGetListUser_whenCallCloudSearchUsers() {
        cloudeUserDataStore.userEntityList(anyString())
        verify(userUservice).searchGithubUsers(anyString())
    }

    @Test
    fun shouldReturnUserWHenGetUserByIdFromApi() {
        val userEntity = UserEntity(1, "name", "url", 2)
        val fakeObserVableUserEntity = Observable.just(userEntity)

        given(userUservice.getUser(anyString())).willReturn(fakeObserVableUserEntity)

        cloudeUserDataStore.userEntitiesById(anyString())

        verify(userUservice).getUser(anyString())

    }

    //    inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)

}