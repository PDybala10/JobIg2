package com.ndesigne.jobig2.domain.usecase

import com.ndesigne.jobig2.data.repository.UserRepository
import com.ndesigne.jobig2.domain.entities.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk

import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreateUserUseCaseTest{
    private val userRepository : UserRepository = mockk()

    private val classUnderTest  = CreateUserUseCase(userRepository)

    @Test
    fun invoke(){
        runBlocking {
            //GIVEN
            val user = User("","")
            coEvery { userRepository.createUser(user) } returns Unit

            //WHEN
            classUnderTest.invoke(user)

            //THEN
            coVerify(exactly = 1 ){userRepository.createUser(user) }
        }
    }
    @Test
    fun `invoke with valid email and password`(){
        runBlocking {
            //GIVEN
            val user = User("a@a.fr","abc")

            coEvery { userRepository.createUser(user) } returns Unit

            //WHEN
            classUnderTest.invoke(user)

            //THEN
            coVerify(exactly = 1 ){userRepository.createUser(user) }
        }
    }
}