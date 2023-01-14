package com.challenge.sophosapp.domain.usecase

import com.challenge.sophosapp.data.models.request.PutDocumentsRequestEntity
import com.challenge.sophosapp.data.models.response.DocumentsUploadResponseModel
import com.challenge.sophosapp.data.repository.DocumentsRepository

class UploadDocumentsUseCase {
    private val repository = DocumentsRepository()

    suspend operator fun invoke(params: PutDocumentsRequestEntity): DocumentsUploadResponseModel {
        return repository.putDocuments(params)
    }
}
