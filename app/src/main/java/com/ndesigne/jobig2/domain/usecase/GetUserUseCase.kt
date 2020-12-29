
package com.ndesigne.jobig2.domain.usecase

import com.ndesigne.jobig2.data.repository.UserRepository
import com.ndesigne.jobig2.domain.entities.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User?{
        return userRepository.getUser(email)
    }
}