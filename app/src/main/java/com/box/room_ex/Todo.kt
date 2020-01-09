package com.box.room_ex

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Todo(
    val title: String
){
    @PrimaryKey(autoGenerate = true) var id : Int = 0
    override fun toString(): String {
        return "Todo($id : $title)"

    }
}

