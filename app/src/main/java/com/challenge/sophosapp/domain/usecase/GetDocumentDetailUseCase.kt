package com.challenge.sophosapp.domain.usecase

import com.challenge.sophosapp.data.mapper.DocumentDetailResponseMapper
import com.challenge.sophosapp.data.repository.DocumentsRepository
import com.challenge.sophosapp.domain.models.DocumentDetailDto

class GetDocumentDetailUseCase {
    private val repository = DocumentsRepository()
    private val mapper = DocumentDetailResponseMapper()

    suspend operator fun invoke(id: String): DocumentDetailDto {
        return mapper.transform(repository.getDocumentsById(id))
    }
}
