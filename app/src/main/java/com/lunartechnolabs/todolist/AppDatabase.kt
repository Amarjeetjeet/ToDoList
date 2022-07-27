package com.lunartechnolabs.todolist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class],version = 1 , exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDAO(): AppDao

    companion object{
        private var dbINSTANCE : AppDatabase?= null

        fun getAppDb(context: Context) : RoomDatabase{
            if (dbINSTANCE ==null){
                dbINSTANCE = Room.databaseBuilder(
                    context.applicationContext , AppDatabase::class.java,"MyDB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return dbINSTANCE!!
        }
    }

}