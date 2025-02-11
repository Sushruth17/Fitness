package com.seventeen.fitness

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.seventeen.fitness.utils.PrefUtils
import com.seventeen.fitness.utils.UtilsString
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUp : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    lateinit var mDatabase :DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference

        btn_sign_up_sign_up.setOnClickListener {
            signUp()
        }


    }

    private fun signUp(){

        val usernameTxt = findViewById<EditText>(R.id.sign_up_name)
        val emailTxt = findViewById<EditText>(R.id.sign_up_email)
        val passwordTxt = findViewById<EditText>(R.id.sign_up_password)

        val username = usernameTxt.text.toString()
        val email = emailTxt.text.toString()
        val password = passwordTxt.text.toString()


        if (email.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty()) {
            mAuth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = mAuth?.currentUser
                        val uid = user!!.uid
                        mDatabase.child(uid).child("userName").setValue(username)
                        mDatabase.child(uid).child("userId").setValue(uid)
                        mDatabase.child(uid).child("countFollowers").setValue("0")
                        mDatabase.child(uid).child("countFollowing").setValue("0")
                        mDatabase.child(uid).child("countPosts").setValue("0")
                        mDatabase.child(uid).child("statusProfileImg").setValue(UtilsString.NOT_UPLOADED)
                        PrefUtils.save(this, UtilsString.USERNAME, username)
                        PrefUtils.save(this, UtilsString.LOGGED_IN, true)
                        startActivity(Intent(this, MainActivity::class.java))
                        Toast.makeText(this, "Successfully registered", Toast.LENGTH_LONG).show()
                    } else {
                        Log.i(TAG, "User Authentication Failed :"+task.exception?.message)
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
        }else {
            Toast.makeText(this,"Please fill up the Credentials", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private var TAG = "SignUp"
    }
}