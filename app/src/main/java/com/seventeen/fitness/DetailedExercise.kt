package com.seventeen.fitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seventeen.fitness.adapter.DashboardAdapter1
import com.seventeen.fitness.adapter.DetailedExerciseAdapter
import com.seventeen.fitness.utils.UtilsString

class DetailedExercise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_exercise)

        val sampleList = listOf("1", "2", "3", "4", "5")

        val rvDetailsExercise = findViewById<RecyclerView>(R.id.rv_detailed_exercise)
        val detailsExerciseAdapter = DetailedExerciseAdapter()
        detailsExerciseAdapter.setDataCustom(sampleList)
        rvDetailsExercise?.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false)
        rvDetailsExercise?.adapter = detailsExerciseAdapter
    }
}