package com.ndesigne.jobig2.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ndesigne.jobig2.domain.entities.User

@Entity
data class UserRoom(
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String
){
    @PrimaryKey(autoGenerate = true) var uid: Int? = null
}

fun User.toData() : UserRoom{
    return UserRoom(
        email = email,
        password = password
    )
}

fun UserRoom.toEntity() : User{
    return User(
        email = email,
        password = password
    )
}