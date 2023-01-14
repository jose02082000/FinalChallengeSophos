package com.challenge.sophosapp.data.repository

import com.challenge.sophosapp.data.models.response.OfficesResponseModel
import com.challenge.sophosapp.data.provider.OfficesProvider
import com.challenge.sophosapp.data.repository.network.OfficesRemote

class OfficesRepository {
    private val api = OfficesRemote()

    suspend fun getOfficesList(): OfficesResponseModel {
        val response = api.getOfficesInfo()
        OfficesProvider.offices = response
        return response
    }
}
