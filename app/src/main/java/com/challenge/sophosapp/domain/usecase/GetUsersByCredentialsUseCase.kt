package com.challenge.sophosapp.domain.usecase

import com.challenge.sophosapp.data.mapper.UserResponseMapper
import com.challenge.sophosapp.data.models.request.UserRequestEntity
import com.challenge.sophosapp.data.repository.UserRepository
import com.challenge.sophosapp.domain.models.UserResponseDto

class GetUsersByCredentialsUseCase {
    private val repository = UserRepository()
    private val mapper: UserResponseMapper = UserResponseMapper()

    suspend operator fun invoke(params: UserRequestEntity): UserResponseDto {
        return mapper.transform(
            repository.getUserByCredentials(params)
        )
    }
}
