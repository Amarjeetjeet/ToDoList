package com.lunartechnolabs.todolist.data.db

/**
 * Database create and db instance initialized
 * Database model name = Task (where table and column present)
 * Database version = 1
 * Database export = false
 */
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lunartechnolabs.todolist.data.local.AppDao
import com.lunartechnolabs.todolist.domain.model.Task

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