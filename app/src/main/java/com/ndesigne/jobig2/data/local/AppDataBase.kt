package com.ndesigne.jobig2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(
    UserRoom::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataBaseDao(): DataBaseDao
}