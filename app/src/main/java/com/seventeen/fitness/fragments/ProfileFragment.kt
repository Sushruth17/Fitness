package com.seventeen.fitness.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.seventeen.fitness.R
import com.seventeen.fitness.Settings
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

//    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
  /*      profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        *//*        val textView: TextView = root.findViewById(R.id.text_profile)
        profileViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_settings.setOnClickListener {
            val intent = Intent(requireContext(), Settings::class.java)
            startActivity(intent)
        }

    }
}