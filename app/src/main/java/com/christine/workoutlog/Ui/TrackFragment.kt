package com.christine.workoutlog.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.christine.workoutlog.databinding.FragmentTrackBinding
import com.christine.workoutlog.viewmodel.WorkoutPlanViewModel


class TrackFragment : Fragment() {
lateinit var binding: FragmentTrackBinding
val workoutPlanViewModel:WorkoutPlanViewModel by viewModels ()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentTrackBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return view.root
    }

    override fun onResume() {
        super.onResume()

    }



}

