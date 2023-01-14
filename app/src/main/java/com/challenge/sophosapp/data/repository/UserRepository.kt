package com.challenge.sophosapp.data.repository

import com.challenge.sophosapp.data.models.request.UserRequestEntity
import com.challenge.sophosapp.data.models.response.UsersResponseModel
import com.challenge.sophosapp.data.provider.UserProvider
import com.challenge.sophosapp.data.repository.network.UsersRemote

class UserRepository {
    private val api = UsersRemote()

    suspend fun getUserByCredentials(params: UserRequestEntity): UsersResponseModel {
        val response = api.getUserInfo(params)
        UserProvider.users = response
        return response
    }
}
