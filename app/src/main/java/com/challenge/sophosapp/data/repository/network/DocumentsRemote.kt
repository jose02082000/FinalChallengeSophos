package com.challenge.sophosapp.data.repository.network

import com.challenge.sophosapp.core.RetrofitHelper
import com.challenge.sophosapp.data.models.request.PutDocumentsRequestEntity
import com.challenge.sophosapp.data.models.response.DocumentDetailResponseModel
import com.challenge.sophosapp.data.models.response.DocumentsListResponseModel
import com.challenge.sophosapp.data.models.response.DocumentsUploadResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DocumentsRemote {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun putDocuments(params: PutDocumentsRequestEntity): DocumentsUploadResponseModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiService::class.java).postDocumentToRepository(params)
            response.body() ?: DocumentsUploadResponseModel()
        }
    }

    suspend fun getDocumentsByEmail(email: String): DocumentsListResponseModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiService::class.java).getDocumentsByEmail(email)
            response.body() ?: DocumentsListResponseModel()
        }
    }

    suspend fun getDocumentsByRegistry(id: String): DocumentDetailResponseModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiService::class.java).getDocumentsByRegistry(id)
            response.body() ?: DocumentDetailResponseModel()
        }
    }
}
