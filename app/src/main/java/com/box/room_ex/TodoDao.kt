package com.box.room_exe

import androidx.room.*
import com.box.room_ex.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll() : List<Todo>

    @Insert
    fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Query("DELETE FROM TODO WHERE ID = :id")
    fun delete(id:Int)
}