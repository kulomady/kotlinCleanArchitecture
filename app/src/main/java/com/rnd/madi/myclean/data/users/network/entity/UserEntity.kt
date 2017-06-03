package com.rnd.madi.myclean.data.users.network.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author madi on 5/31/17.
 */

data class UserEntity(
        @SerializedName("id")
        val id: Long,
        @SerializedName("name")
        val name: String?,
        @SerializedName("avatar_url")
        @Expose
        val photoUrls: String?,
        @SerializedName("public_repos")
        @Expose
        val reposUrl: Int?
)