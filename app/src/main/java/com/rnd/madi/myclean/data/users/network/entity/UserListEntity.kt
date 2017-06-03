package com.rnd.madi.myclean.data.users.network.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * @author madi on 5/31/17.
 */

data class UserListEntity(
        @SerializedName("total_count")
        @Expose
        val totalCount: Int?,
        @SerializedName("items")
        @Expose
        val items :ArrayList<UserEntity> = ArrayList<UserEntity>()
)