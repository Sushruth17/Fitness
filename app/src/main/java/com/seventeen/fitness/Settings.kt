package com.seventeen.fitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.seventeen.fitness.utils.PrefUtils
import com.seventeen.fitness.utils.UtilsString
import kotlinx.android.synthetic.main.activity_settings.*
import kotlin.properties.Delegates

class Settings : AppCompatActivity() {
    var mode by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        dark_switch.isChecked =
            PrefUtils.getValueBoolien(this, UtilsString.NIGHT_MODE, false)

        dark_switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                mode = AppCompatDelegate.MODE_NIGHT_YES
                PrefUtils.save(this, UtilsString.NIGHT_MODE, true)
                AppCompatDelegate.setDefaultNightMode(mode)
            }
            else{
                mode = AppCompatDelegate.MODE_NIGHT_NO
                PrefUtils.save(this, UtilsString.NIGHT_MODE, false)
                AppCompatDelegate.setDefaultNightMode(mode)
            }
        }

    }
}