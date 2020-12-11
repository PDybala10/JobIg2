package com.ndesigne.jobig2.domain.usecase

import com.ndesigne.jobig2.data.repository.UserRepository
import com.ndesigne.jobig2.domain.entities.User

class CreateUserUserCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}
