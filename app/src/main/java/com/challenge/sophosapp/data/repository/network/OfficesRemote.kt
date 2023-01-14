package com.challenge.sophosapp.data.repository.network

import com.challenge.sophosapp.core.RetrofitHelper
import com.challenge.sophosapp.data.models.response.OfficesResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OfficesRemote {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getOfficesInfo(): OfficesResponseModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiService::class.java).getOfficesList()
            response.body() ?: OfficesResponseModel()
        }
    }
}
