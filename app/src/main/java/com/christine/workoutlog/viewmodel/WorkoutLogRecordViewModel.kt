package com.christine.workoutlog.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.christine.workoutlog.models.WorkoutLogRecord
import com.christine.workoutlog.repository.WorkoutLogRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class WorkoutLogRecordViewModel: ViewModel() {
    val workoutLogRepository = WorkoutLogRepository()
    lateinit var todaysRecordsLiveData: LiveData<List<WorkoutLogRecord>>

    fun saveWorkoutLogRecord(workoutLogRecord: WorkoutLogRecord){
        viewModelScope.launch {
            workoutLogRepository.saveWorkoutLogRecord(workoutLogRecord) }
    }
    fun getTodaysWorkoutLogRecords(userId:String){
        todaysRecordsLiveData = workoutLogRepository
            .getTodaysWorkoutLogRecords(userId,getCurrentDate())
    }

    fun getCurrentDate(): String{
        val formatter = SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH)
        return formatter.format(Date())
    }
}