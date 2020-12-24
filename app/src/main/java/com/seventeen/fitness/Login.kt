package com.seventeen.fitness

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        btn_login.setOnClickListener {

                login()
        }

        btn_sign_up.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth?.currentUser
//        updateUI(currentUser)
    }

    private fun login () {

        val emailTxt = findViewById<EditText>(R.id.login_email)
        val passwordTxt = findViewById<EditText>(R.id.login_password)

        val email = emailTxt.text.toString()
        val password = passwordTxt.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            mAuth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener ( this) { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                        Toast.makeText(this, "Successfully Logged in", Toast.LENGTH_LONG).show()
                    } else {
                        Log.i(TAG, "login failure-->: "+task.exception)
                        Toast.makeText(this, "Error Logging in", Toast.LENGTH_SHORT).show()
                    }
                }

        }else {
            Toast.makeText(this, "Please fill up the Credentials", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private var TAG = "Login"
    }
}