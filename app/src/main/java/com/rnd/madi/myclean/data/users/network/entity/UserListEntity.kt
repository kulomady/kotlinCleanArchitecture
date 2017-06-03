package com.rnd.madi.myclean.data.users.network.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * @author madi on 5/31/17.
 */

data class UserListEntity(
        @SerializedName("total_count")
        @Expose
        private val totalCount: Int?,
        @SerializedName("items")
        @Expose
        private val items :ArrayList<UserEntity> = ArrayList<UserEntity>()
)