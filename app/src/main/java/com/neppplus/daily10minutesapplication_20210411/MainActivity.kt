package com.neppplus.daily10minutesapplication_20210411

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.daily10minutesapplication_20210411.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        loginBtn.setOnClickListener {

            val inputEmail = emailEdt.text.toString()
            val inputPassword = passwordEdt.text.toString()

            ServerUtil.postRequestLogin(inputEmail, inputPassword)
        }

    }

    override fun setValues() {

    }


}