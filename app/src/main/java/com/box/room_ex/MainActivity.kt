package com.box.room_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomMasterTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            this@MainActivity,
            AppDatabase::class.java,
            "todo-db"
        ).allowMainThreadQueries().build()

        //refresh UI
        db.todoDao().getAll().observe(this,
            Observer {
                result_text.text = it.toString()
            })
        add_btn.setOnClickListener {
            db.todoDao().insert(Todo(todo_edit.text.toString()))
        }
        remove_btn.setOnClickListener {
            db.todoDao().delete(todo_edit.text.toString().toInt())
        }
    }

}
