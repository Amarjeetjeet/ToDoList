package com.lunartechnolabs.todolist.data.local

import androidx.room.*
import com.lunartechnolabs.todolist.domain.model.Task


@Dao
interface AppDao {

    @Query("SELECT * FROM Task_table")
    fun getTask(): MutableList<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListTask(task: List<Task>)

    @Insert
    fun insertSingleTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTask(task: Task)

}