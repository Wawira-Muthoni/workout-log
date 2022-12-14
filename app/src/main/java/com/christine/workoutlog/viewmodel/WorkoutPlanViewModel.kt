package com.christine.workoutlog.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.christine.workoutlog.WorkouPlanItem
import com.christine.workoutlog.WorkoutPlan
import com.christine.workoutlog.repository.WorkoutPlanRepository
import kotlinx.coroutines.launch
import java.util.*

class WorkoutPlanViewModel: ViewModel() {
    val workoutPlanRepository= WorkoutPlanRepository()
    lateinit var workoutPlanLiveData: LiveData<WorkoutPlan>
    var selectedExerciseIds = mutableListOf<String>()

    fun saveWorkoutPlan(workoutPlan: WorkoutPlan){
        viewModelScope.launch {
            workoutPlanRepository.saveWorkoutPlan(workoutPlan)
        }
    }
    fun getExistingWorkoutPlans(userId: String){
        workoutPlanLiveData = workoutPlanRepository.getWorkoutPlanByUserId(userId)
    }

    fun createWorkoutPlanItem(dayNumber: Int, workoutPlanId: String){
        val workoutPlanItem = WorkouPlanItem(
            workoutPlanItemId = UUID.randomUUID().toString(),
            workoutPlanId = workoutPlanId,
            day =dayNumber,
          exerciseId = selectedExerciseIds
        )
    viewModelScope.launch{
        workoutPlanRepository.saveWorkoutPlanItem(workoutPlanItem)
    }


}
}