package com.christine.workoutlog.repository

import androidx.lifecycle.LiveData
import com.christine.workoutlog.database.WorkoutDb
import com.christine.workoutlog.models.WorkoutLogRecord
import com.christine.workoutlog.viewModel.WorkoutLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorkoutLogRepository {
    val database =WorkoutDb.getDatabase(WorkoutLog.appContext)
    val workoutLogRecordDao =database.workoutLogDao()

     suspend fun saveWorkoutLogRecord(workoutLogRecord: WorkoutLogRecord){
        withContext(Dispatchers.IO){
            workoutLogRecordDao.insertWorkoutLogRecord(workoutLogRecord)
        }
    }
    fun getTodaysWorkoutLogRecords(userId:String, currentDate: String): LiveData<List<WorkoutLogRecord>>{
        return  workoutLogRecordDao.getWorkoutLogsById(userId,currentDate)

    }

}