package com.ndesigne.jobig2.domain.usecase

import com.ndesigne.jobig2.data.repository.UserRepository
import com.ndesigne.jobig2.domain.entities.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetUserUseCaseTest{
    private val userRepository : UserRepository = mockk()

    private val classUnderTest  = GetUserUseCase(userRepository)

    @Test
    fun invoke(){
        runBlocking {
            //GIVEN
            val email =""
            coEvery { userRepository.getUser(email) } returns null

            //WHEN
            classUnderTest.invoke(email)

            //THEN
            coVerify(exactly = 1 ){userRepository.getUser(email) }
        }
    }
    @Test
    fun `invoke with valid email and password`(){
        runBlocking {
            //GIVEN
            val email ="a@a.fr"
            val user = User("a@a.fr","abc")
            coEvery { userRepository.getUser(email) } returns user

            //WHEN
            val result = classUnderTest.invoke(email)

            //THEN
            coVerify(exactly = 1 ){userRepository.getUser(email) }
            assertEquals(result, user)
        }
    }
    @Test
    fun `invoke with invalid email and password`(){
        runBlocking {
            //GIVEN
            val email =""
            coEvery { userRepository.getUser(email) } returns null

            //WHEN
            val result = classUnderTest.invoke(email)

            //THEN
            coVerify(exactly = 1 ){userRepository.getUser(email) }
            assertEquals(result, null)
        }
    }
}