package com.seventeen.fitness.ui.dashboard

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.seventeen.fitness.R
import com.seventeen.fitness.adapter.HomeAdapter1
import com.seventeen.fitness.utils.UtilsString
import kotlin.properties.Delegates

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var mode by Delegates.notNull<Int>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        /*val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

/*    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dark_switch.isChecked =
            PrefUtils.getValueBoolien(requireContext(), UtilsString.NIGHT_MODE, false)

        dark_switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                mode = AppCompatDelegate.MODE_NIGHT_YES
                PrefUtils.save(requireContext(), UtilsString.NIGHT_MODE, true)
                AppCompatDelegate.setDefaultNightMode(mode)
            }
            else{
                mode = AppCompatDelegate.MODE_NIGHT_NO
                PrefUtils.save(requireContext(), UtilsString.NIGHT_MODE, false)
                AppCompatDelegate.setDefaultNightMode(mode)
            }
        }


    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        val collapsingToolbar =
            getView()?.findViewById(R.id.collapsing_toolbar) as CollapsingToolbarLayout
        collapsingToolbar.title = "Fitness"
        collapsingToolbar.setCollapsedTitleTextColor(resources.getColor(R.color.textPrimary))
        collapsingToolbar.setExpandedTitleColor(resources.getColor(R.color.textPrimary))
        collapsingToolbar.setCollapsedTitleTypeface(Typeface.DEFAULT_BOLD)
        collapsingToolbar.setExpandedTitleTypeface(Typeface.DEFAULT_BOLD)

        val fitnessTypeList = listOf("ABS","CHEST","ARM","LEG","SHOULDER \n & BACK")


        val rvHome1 = getView()?.findViewById<RecyclerView>(R.id.rv_home_1)
        val homeAdapter1 = HomeAdapter1()
        homeAdapter1.setDataCustom(fitnessTypeList,UtilsString.BEGINNER)
        rvHome1?.layoutManager  = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false)
        rvHome1?.adapter = homeAdapter1


        val rvHome2 = getView()?.findViewById<RecyclerView>(R.id.rv_home_2)
        val homeAdapter2 = HomeAdapter1()
        homeAdapter2.setDataCustom(fitnessTypeList,UtilsString.INTERMEDIATE)
        rvHome2?.layoutManager  = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false)
        rvHome2?.adapter = homeAdapter2

        val rvHome3 = getView()?.findViewById<RecyclerView>(R.id.rv_home_3)
        val homeAdapter3 = HomeAdapter1()
        homeAdapter3.setDataCustom(fitnessTypeList,UtilsString.ADVANCED)
        rvHome3?.layoutManager  = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false)
        rvHome3?.adapter = homeAdapter3

    }
}