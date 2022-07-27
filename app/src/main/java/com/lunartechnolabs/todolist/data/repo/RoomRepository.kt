package com.lunartechnolabs.todolist.data.repo

import com.lunartechnolabs.todolist.data.local.AppDao
import com.lunartechnolabs.todolist.domain.model.Task
import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: AppDao) {

    fun getRecords(): MutableList<Task>{
        return appDao.getTask()
    }

    fun insertSingleTask(task: Task) {
         appDao.insertSingleTask(task)
    }

    fun insertRecords(task: List<Task>) {
        appDao.insertListTask(task)
    }

    fun deleteTask(task: Task){
        appDao.deleteTask(task)
    }

    fun updateTask(task: Task) {
        appDao.updateTask(task)
    }
}