package com.lunartechnolabs.todolist.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lunartechnolabs.todolist.data.repo.RoomRepository
import com.lunartechnolabs.todolist.domain.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashBoardViewModel @Inject constructor(private val roomRepository: RoomRepository) : ViewModel() {
    /**
     * private mutable stateflow for accessing and updating data
     */

    private val _offlineArticleState = MutableStateFlow<Resource<MutableList<Task>>>(Resource.Loading())

    /**
     * public  stateflow for accessing and updating data from other class
     */


    val offlineArticleUIState: StateFlow<Resource<MutableList<Task>>> = _offlineArticleState

    /**
     * This function is use to add  single Article in local database
     */


    fun addArticle(task: Task){
        CoroutineScope(Dispatchers.IO).launch {
            roomRepository.insertSingleTask(task)
            fetchOfflineArticle()
        }
    }

    /**
     * This function is use to fetch for all the Article list from local database
     */

    fun fetchOfflineArticle() =  viewModelScope.launch{
        _offlineArticleState.value = Resource.Loading()
        val response =  roomRepository.getRecords()

        if (response.isNotEmpty()) {
            _offlineArticleState.value = Resource.Success(response)
        } else {
            _offlineArticleState.value = Resource.Error("No Data Found")
        }
    }

    /**
     * This function is use to delete single the Article in local database
     */

    fun deleteArticle(task: Task){
        CoroutineScope(Dispatchers.IO).launch {
            roomRepository.deleteTask(task)
            fetchOfflineArticle()
        }
    }

    /**
     * This function is use to Update Single Article in local database
     */

    fun updateArticle(task: Task){
        CoroutineScope(Dispatchers.IO).launch {
            roomRepository.updateTask(task)
            fetchOfflineArticle()
        }
    }
}

sealed class Resource<T>(val data : T?= null, val errorMessage: String?=null) {
    class Loading<T> : Resource<T>()
    class Success<T>(data : T) : Resource<T>(data = data)
    class Error<T>(errorMessage: String) : Resource<T>(errorMessage = errorMessage)
}
