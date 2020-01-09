package com.box.room_ex

import androidx.room.Database
import androidx.room.RoomDatabase
import com.box.room_exe.TodoDao

@Database(entities = [Todo::class],version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao():TodoDao
}