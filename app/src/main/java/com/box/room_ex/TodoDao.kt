package com.box.room_exe

import androidx.lifecycle.LiveData
import androidx.room.*
import com.box.room_ex.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll() : LiveData<List<Todo>>

    @Insert
    suspend fun insert(todo: Todo)

    @Update
    suspend fun update(todo: Todo)

    @Query("DELETE FROM TODO WHERE ID = :id")
    suspend fun delete(id:String)
}