package com.seventeen.fitness.utils

import android.content.Context
import android.content.SharedPreferences

class
PrefUtils(val context: Context) {
    companion object {


        private const val PREFS_NAME = "fitness"


        fun save(context: Context, KEY_NAME: String, text: String) {
            val sharedPref: SharedPreferences =
                context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPref.edit()
            editor.putString(KEY_NAME, text)
            editor.apply()
        }
        fun getValueString(context: Context,KEY_NAME: String): String? {

            val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

            return sharedPref.getString(KEY_NAME, null)


        }

        fun save(context: Context,KEY_NAME: String, value: Int) {
            val sharedPref: SharedPreferences =
                context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPref.edit()

            editor.putInt(KEY_NAME, value)

            editor.apply()
        }

        fun save(context: Context,KEY_NAME: String, status: Boolean) {
            val sharedPref: SharedPreferences =
                context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPref.edit()

            editor.putBoolean(KEY_NAME, status)

            editor.apply()
        }



        fun getValueInt(context: Context,KEY_NAME: String): Int {
            val sharedPref: SharedPreferences =
                context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            return sharedPref.getInt(KEY_NAME, 0)
        }

        fun getValueBoolean(context: Context, KEY_NAME: String, defaultValue: Boolean): Boolean {
            val sharedPref: SharedPreferences =
                context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            return sharedPref.getBoolean(KEY_NAME, defaultValue)

        }

        fun clearSharedPreference(context: Context) {
            val sharedPref: SharedPreferences =
                context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPref.edit()

            //sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

            editor.clear()
            editor.apply()
        }

        fun removeValue(context: Context,KEY_NAME: String) {
            val sharedPref: SharedPreferences =
                context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPref.edit()

            editor.remove(KEY_NAME)
            editor.apply()
        }
    }
}