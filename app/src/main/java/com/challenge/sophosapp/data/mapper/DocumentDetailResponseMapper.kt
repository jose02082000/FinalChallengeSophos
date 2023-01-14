package com.challenge.sophosapp.data.mapper

import com.challenge.sophosapp.data.models.response.DocumentDetailModel
import com.challenge.sophosapp.data.models.response.DocumentDetailResponseModel
import com.challenge.sophosapp.domain.models.DocumentDetailDto
import com.challenge.sophosapp.domain.models.DocumentDetailedInfoDto

class DocumentDetailResponseMapper {
    fun transform(value: DocumentDetailResponseModel): DocumentDetailDto {
        return DocumentDetailDto(
            itemList = transformDocumentsModelList(value.items),
            count = value.count ?: 0,
            scannedCount = value.scannedCount ?: 0
        )
    }

    private fun transformDocumentsModelList(documentsList: List<DocumentDetailModel>): List<DocumentDetailedInfoDto> {
        return documentsList.map { transformDocumentsModel(it) }
    }

    private fun transformDocumentsModel(documentDetail: DocumentDetailModel): DocumentDetailedInfoDto {
        return DocumentDetailedInfoDto(
            id = documentDetail.id,
            date = documentDetail.date,
            idType = documentDetail.idType,
            identification = documentDetail.identification,
            name = documentDetail.name,
            lastName = documentDetail.lastName,
            city = documentDetail.city,
            email = documentDetail.email,
            attachmentType = documentDetail.attachmentType,
            attachment = documentDetail.attachment
        )
    }
}