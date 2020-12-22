package com.seventeen.fitness.ui.home

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.seventeen.fitness.R
import com.seventeen.fitness.adapter.HomeAdapter1
import com.seventeen.fitness.adapter.HomeAdapter2
import com.seventeen.fitness.utils.UtilsString


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fitnessTypeList = listOf("1", "2", "3", "4", "5", "6")


        val rvHome1 = getView()?.findViewById<RecyclerView>(R.id.rv_stories)
        val homeAdapter1 = HomeAdapter2()
        homeAdapter1.setDataCustom(fitnessTypeList)
        rvHome1?.layoutManager  = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false)
        rvHome1?.adapter = homeAdapter1

    }
}