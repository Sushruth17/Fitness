package com.seventeen.fitness

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.seventeen.fitness.utils.PrefUtils
import com.seventeen.fitness.utils.UtilsString


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (PrefUtils.getValueBoolean(this, UtilsString.NIGHT_MODE, false)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            // Name, email address, and profile photo Url
            val name = user.displayName
            val email = user.email
            val photoUrl: Uri? = user.photoUrl

            // Check if user's email is verified
            val emailVerified = user.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            val uid = user.uid
            Log.i(TAG, "onCreate: name---->$name")
            Log.i(TAG, "onCreate: email---->$email")
            Log.i(TAG, "onCreate: photoUrl---->$photoUrl")
            Log.i(TAG, "onCreate: emailVerified---->$emailVerified")
            Log.i(TAG, "onCreate: uid---->$uid")
        }
//
//        TypefaceUtil.overrideFont(applicationContext,
//            "SERIF",
//            "fonts/nexa_light.otf")

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_profile
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val menu: Menu = navView.menu

 
    }
    companion object{
        private const val TAG = "MainActivity"
    }
}