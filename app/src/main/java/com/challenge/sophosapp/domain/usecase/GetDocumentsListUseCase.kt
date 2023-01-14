package com.challenge.sophosapp.domain.usecase

import com.challenge.sophosapp.data.mapper.DocumentsListResponseMapper
import com.challenge.sophosapp.data.repository.DocumentsRepository
import com.challenge.sophosapp.domain.models.DocumentsListDto

class GetDocumentsListUseCase {
    private val repository = DocumentsRepository()
    private val mapper: DocumentsListResponseMapper = DocumentsListResponseMapper()

    suspend operator fun invoke(email: String): DocumentsListDto {
        return mapper.transform(repository.getDocumentsByEmail(email))
    }
}
