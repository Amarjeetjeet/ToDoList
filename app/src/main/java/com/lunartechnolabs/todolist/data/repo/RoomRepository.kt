package com.lunartechnolabs.todolist.data.repo

import com.lunartechnolabs.todolist.data.local.AppDao
import com.lunartechnolabs.todolist.domain.model.Task
import javax.inject.Inject



/**
 * Local Repository class implementation
 * This class will communication with view Model , Activity not DAO
 */

class RoomRepository @Inject constructor(private val appDao: AppDao) {

    /**
     * Get record from database via DAO
     */
    fun getRecords(): MutableList<Task>{
        return appDao.getTask()
    }

    /**
     * Insert record from database via DAO
     */
    fun insertSingleTask(task: Task) {
         appDao.insertSingleTask(task)
    }

    /**
     * Insert list of Recode in database via DAO
     */
    fun insertRecords(task: List<Task>) {
        appDao.insertListTask(task)
    }

    /**
     * Delete record in database via DAO
     */
    fun deleteTask(task: Task){
        appDao.deleteTask(task)
    }

    /**
     * Update record in database via DAO
     */
    fun updateTask(task: Task) {
        appDao.updateTask(task)
    }
}