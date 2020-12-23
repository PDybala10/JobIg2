package com.ndesigne.jobig2.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ndesigne.jobig2.domain.entities.User

@Dao
interface DataBaseDao {
    @Query("SELECT * FROM UserRoom")
    fun getAll(): List<UserRoom>

    @Query("SELECT * FROM UserRoom WHERE email LIKE :email LIMIT 1")
    fun findByEmail(email: String): UserRoom?

    @Insert
    fun insert(user: UserRoom)

    @Delete
    fun delete(user: UserRoom)
}