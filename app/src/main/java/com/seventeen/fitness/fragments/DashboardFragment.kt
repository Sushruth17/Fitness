package com.seventeen.fitness.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.seventeen.fitness.R
import com.seventeen.fitness.adapter.DashboardAdapter1
import com.seventeen.fitness.utils.UtilsString

class DashboardFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        val collapsingToolbar =
            getView()?.findViewById(R.id.collapsing_toolbar) as CollapsingToolbarLayout
        collapsingToolbar.title = "Fitness"
        collapsingToolbar.setCollapsedTitleTextColor(resources.getColor(R.color.colorPrimary))
        collapsingToolbar.setExpandedTitleColor(resources.getColor(R.color.colorPrimary))
        collapsingToolbar.setCollapsedTitleTypeface(Typeface.DEFAULT_BOLD)
        collapsingToolbar.setExpandedTitleTypeface(Typeface.DEFAULT_BOLD)

        val fitnessTypeList = listOf("ABS","CHEST","ARM","LEG","SHOULDER \n & BACK")


        val rvDashboard1 = getView()?.findViewById<RecyclerView>(R.id.rv_dashboard_1)
        val dashboardAdapter1 = DashboardAdapter1(requireContext())
        dashboardAdapter1.setDataCustom(fitnessTypeList,UtilsString.BEGINNER)
        rvDashboard1?.layoutManager  = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false)
        rvDashboard1?.adapter = dashboardAdapter1


        val rvDashboard2 = getView()?.findViewById<RecyclerView>(R.id.rv_dashboard_2)
        val dashboardAdapter2 = DashboardAdapter1(requireContext())
        dashboardAdapter2.setDataCustom(fitnessTypeList,UtilsString.INTERMEDIATE)
        rvDashboard2?.layoutManager  = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false)
        rvDashboard2?.adapter = dashboardAdapter2


        val rvDashboard3 = getView()?.findViewById<RecyclerView>(R.id.rv_dashboard_3)
        val dashboardAdapter3 = DashboardAdapter1(requireContext())
        dashboardAdapter3.setDataCustom(fitnessTypeList,UtilsString.ADVANCED)
        rvDashboard3?.layoutManager  = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false)
        rvDashboard3?.adapter = dashboardAdapter3

    }
}