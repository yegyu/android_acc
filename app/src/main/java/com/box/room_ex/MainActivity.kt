package com.box.room_ex

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomMasterTable
import com.box.room_ex.databinding.ActivityMainBinding
import com.box.room_exe.TodoDao
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this )
            .get(MainViewModel::class.java)

        binding.lifecycleOwner = this
        binding.vm = viewModel

        //refresh UI
//        viewModel.getAll().observe(this,
//            Observer {
//                result_text.text = it.toString()
//            })
//
//        add_btn.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                viewModel.insert(Todo(todo_edit.text.toString()))
//            }
//        }
//        remove_btn.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                 viewModel.delete(todo_edit.text.toString().toInt())
//            }
//        }
    }
}
