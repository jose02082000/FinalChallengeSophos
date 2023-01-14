package com.challenge.sophosapp.domain.usecase

import com.challenge.sophosapp.data.mapper.OfficesResponseMapper
import com.challenge.sophosapp.data.repository.OfficesRepository
import com.challenge.sophosapp.domain.models.OfficesResponseDto

class GetOfficesListUseCase {
    private val repository = OfficesRepository()
    private val mapper = OfficesResponseMapper()

    suspend operator fun invoke(): OfficesResponseDto {
        return mapper.transform(
            repository.getOfficesList()
        )
    }
}
