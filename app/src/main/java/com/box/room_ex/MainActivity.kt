package com.box.room_ex

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomMasterTable
import com.box.room_exe.TodoDao
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            this@MainActivity,
            AppDatabase::class.java,
            "todo-db"
        ).build()

        //refresh UI
        db.todoDao().getAll().observe(this,
            Observer {
                result_text.text = it.toString()
            })

        add_btn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                db.todoDao().insert(Todo(todo_edit.text.toString()))
            }
        }
        remove_btn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                 db.todoDao().delete(todo_edit.text.toString().toInt())
            }
        }
    }
}
