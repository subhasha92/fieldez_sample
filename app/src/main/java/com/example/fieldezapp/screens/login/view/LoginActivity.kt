package com.example.fieldezapp.screens.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fieldezapp.R
import com.example.fieldezapp.data.DataUtil
import com.example.fieldezapp.screens.userlist.view.LandingActivity
import kotlinx.android.synthetic.main.include_login_layout.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLgin.setOnClickListener {
            if (isValidUser())
                startActivity(Intent(this, LandingActivity::class.java))
        }


    }

    private fun isValidUser(): Boolean {
        if (etUserName.text.isNullOrBlank()) {
            etUserName.error = "Username cant be blank"
            etUserName.requestFocus()
            return false
        }
        if (etPassword.text.isNullOrBlank()) {
            etPassword.error = "Password cant be blank"
            etPassword.requestFocus()
            return false
        }
        return if (etUserName.text.toString()
                .equals(DataUtil.getUserName()) && etPassword.text.toString()
                .equals(DataUtil.getPassWord())
        )
            true
        else {
            Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show()
            false
        }

    }


}


