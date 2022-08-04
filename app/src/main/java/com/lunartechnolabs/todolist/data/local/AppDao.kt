package com.lunartechnolabs.todolist.data.local

import androidx.room.*
import com.lunartechnolabs.todolist.domain.model.Task


/**
 * App Dao for access your application’s persisted data.
 * A DAO can be either an interface or an abstract class
 */
@Dao
interface AppDao {


    /**
     * Select Query task_table
     */
    @Query("SELECT * FROM Task_table ORDER BY priority DESC")
    fun getTask(): MutableList<Task>

    /**
     * Insert List  Query task_table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListTask(task: List<Task>)

    /**
     * Insert Single Query task_table
     */
    @Insert
    fun insertSingleTask(task: Task)


    /**
     * Delete Query task_table
     */
    @Delete
    fun deleteTask(task: Task)

    /**
     * Update Query task_table
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTask(task: Task)

}