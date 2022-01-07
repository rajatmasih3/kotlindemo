package com.ipe.demoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.ipe.demoapp.R


class RoomsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)

    /*  val room = Room.databaseBuilder(this, AppDatabase::class.java,"student_db").build()
       val studentDao =  room.studentDao()
        studentDao.addStudent(Student(1,"RAJA","Golmuri"))*/
    }
}