package com.lunartechnolabs.todolist.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Update record in database via DAO
 */
@Parcelize
@Entity(tableName = "Task_table")
data class Task(
    /**
     * primary key with auto increment
     */
    @PrimaryKey(autoGenerate = true)
    var id : Int ?= null,
    val title :String,
    val priority : String,
    val detail : String,
    val taskDate : String,
    val taskTime : String,
) :Parcelable
