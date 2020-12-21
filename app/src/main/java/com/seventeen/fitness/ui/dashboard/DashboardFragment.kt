package com.seventeen.fitness.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.seventeen.fitness.R
import com.seventeen.fitness.utils.PrefUtils
import com.seventeen.fitness.utils.UtilsString
import kotlinx.android.synthetic.main.fragment_dashboard.*
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
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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


    }
}