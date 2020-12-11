package com.ndesigne.jobig2.domain.usecase

import com.ndesigne.jobig2.data.repository.UserRepository
import com.ndesigne.jobig2.domain.entities.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}
