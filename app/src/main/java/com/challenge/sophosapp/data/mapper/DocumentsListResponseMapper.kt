package com.challenge.sophosapp.data.mapper

import com.challenge.sophosapp.data.models.response.DocumentInfoModel
import com.challenge.sophosapp.data.models.response.DocumentsListResponseModel
import com.challenge.sophosapp.domain.models.DocumentGeneralInfoDto
import com.challenge.sophosapp.domain.models.DocumentsListDto

class DocumentsListResponseMapper {
    fun transform(value: DocumentsListResponseModel): DocumentsListDto {
        return DocumentsListDto(
            itemList = transformDocumentsModelList(value.items),
            count = value.count ?: 0,
            scannedCount = value.scannedCount ?: 0
        )
    }

    private fun transformDocumentsModelList(documentsList: List<DocumentInfoModel>): List<DocumentGeneralInfoDto> {
        return documentsList.map { transformDocumentsModel(it) }
    }

    private fun transformDocumentsModel(documentDetail: DocumentInfoModel): DocumentGeneralInfoDto {
        return DocumentGeneralInfoDto(
            id = documentDetail.id,
            date = documentDetail.date,
            attachmentType = documentDetail.attachmentType,
            name = documentDetail.name,
            lastName = documentDetail.lastName
        )
    }
}
