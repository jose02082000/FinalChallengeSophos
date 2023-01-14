package com.challenge.sophosapp.data.mapper

import com.challenge.sophosapp.data.models.response.UsersResponseModel
import com.challenge.sophosapp.domain.models.UserResponseDto

class UserResponseMapper {
    fun transform(value: UsersResponseModel): UserResponseDto {
        return UserResponseDto(
            id = value.id,
            name = value.name,
            lastName = value.lastName,
            access = value.access,
            admin = value.admin
        )
    }
}
