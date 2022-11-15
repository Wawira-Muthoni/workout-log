package com.christine.workoutlog.repository

import androidx.lifecycle.LiveData
import com.christine.workoutlog.WorkouPlanItem
import com.christine.workoutlog.WorkoutPlan
import com.christine.workoutlog.database.WorkoutDb
import com.christine.workoutlog.viewModel.WorkoutLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorkoutPlanRepository {
    val database = WorkoutDb.getDatabase(WorkoutLog.appContext)
    val workoutPlanDao = database.workoutPlanDao()
    val workoutPlanItemDao = database.workoutPlanItemDao()
//    val  workoutPlanId = database

    suspend fun saveWorkoutPlan(workoutPlan: WorkoutPlan) {
        withContext(Dispatchers.IO) {
            workoutPlanDao.insertWorkoutPlan(workoutPlan)
        }
    }
    suspend fun saveWorkoutPlanItem (workoutPlanItem: WorkouPlanItem){
        withContext(Dispatchers.IO){
            workoutPlanItemDao.insertWorkoutPlanItem(workoutPlanItem)
        }
    }
    fun getWorkoutPlanByUserId(userId: String): LiveData<WorkoutPlan> {
        return workoutPlanDao.getWorkoutPlanByUserId(userId)
    }
//    fun createWorkoutPlanItem(dayNumber:Int,workoutPlanId:String){
//        val workoutPlanItem=WorkouPlanItem(workoutPlanItemId = UUID.randomUUID().toString(),workoutPlanId=workoutPlanId,
//            day = dayNumber, exerciseId = selectedExercisesIds)
//        viewModelScope.launch {
//            WorkoutPlanRepository.saveWorkoutPlanItem(workoutPlanItem)
//        }
//
//    }

}




