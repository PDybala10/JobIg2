package com.ndesigne.jobig2.data.repository

import com.ndesigne.jobig2.data.local.DataBaseDao
import com.ndesigne.jobig2.data.local.UserRoom
import com.ndesigne.jobig2.data.local.toData
import com.ndesigne.jobig2.data.local.toEntity
import com.ndesigne.jobig2.domain.entities.User


class UserRepository(
        private val dataBaseDao: DataBaseDao
) {
        suspend fun createUser(user : User){
                dataBaseDao.insert(user.toData())
        }

         fun getUser(email: String ): User?{
             val userRoom = dataBaseDao.findByEmail(email)
             return userRoom?.toEntity()
        }

}