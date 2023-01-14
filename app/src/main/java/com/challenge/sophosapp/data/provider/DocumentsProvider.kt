package com.challenge.sophosapp.data.provider

import com.challenge.sophosapp.data.models.response.DocumentDetailResponseModel
import com.challenge.sophosapp.data.models.response.DocumentsListResponseModel
import com.challenge.sophosapp.data.models.response.DocumentsUploadResponseModel

class DocumentsProvider {
    companion object {
        var putOperationResult: DocumentsUploadResponseModel = DocumentsUploadResponseModel()
        var getByEmailOperationResult: DocumentsListResponseModel = DocumentsListResponseModel()
        var getByIdOperationResult: DocumentDetailResponseModel = DocumentDetailResponseModel()
    }
}
