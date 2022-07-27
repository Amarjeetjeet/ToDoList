package com.lunartechnolabs.todolist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task_table")
data class Task(
    @PrimaryKey
    val title :String,
    val priority : String,
    val detail : String,
    val createdAt : Long,
    val updateAt : Long,
)
