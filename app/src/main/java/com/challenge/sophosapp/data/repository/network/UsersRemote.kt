package com.challenge.sophosapp.data.repository.network

import com.challenge.sophosapp.core.RetrofitHelper
import com.challenge.sophosapp.data.models.request.UserRequestEntity
import com.challenge.sophosapp.data.models.response.UsersResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsersRemote {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getUserInfo(params: UserRequestEntity): UsersResponseModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiService::class.java).getUserByCredentials(params.userId, params.key)
            response.body() ?: UsersResponseModel()
        }
    }
}
