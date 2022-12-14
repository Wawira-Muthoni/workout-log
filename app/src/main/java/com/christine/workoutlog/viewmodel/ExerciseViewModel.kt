package com.christine.workoutlog.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.christine.workoutlog.models.ExerciseCategory
import com.christine.workoutlog.models.Exercises
import com.christine.workoutlog.repository.ExerciseRepository
import kotlinx.coroutines.launch

class ExerciseViewModel:ViewModel() {
    val exerciseRepository = ExerciseRepository()
    lateinit var exerciseCategoryLiveData : LiveData<List<ExerciseCategory>>
    lateinit var  exerciseLiveData : LiveData<List<Exercises>>
    var selectedExerciseIds = mutableListOf<String>()
    val errorLiveData = MutableLiveData<String?>()


    fun fetchExerciseCategories(accessToken: String) {
        viewModelScope.launch {
            val response = exerciseRepository.fetchExerciseCategories(accessToken)
            if (response.isSuccessful) {
                errorLiveData.postValue(response.body()?.toString())
            }
        }
    }
    fun fetchExercises(accessToken: String) {
        viewModelScope.launch {
            val response = exerciseRepository.fetchExercises(accessToken)

        }
    }


    fun fetchDbCategories(){
        exerciseCategoryLiveData = exerciseRepository.getDbCategories()
    }
    fun fetchDbExercises(){
        exerciseLiveData = exerciseRepository.getDbExercises()
    }
    fun getExerciseByCategoryId (categoryId: String){
        exerciseLiveData = exerciseRepository.getExerciseByCategoryId(categoryId)
    }
}
