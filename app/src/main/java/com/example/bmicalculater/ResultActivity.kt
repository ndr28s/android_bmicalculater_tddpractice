package com.example.bmicalculater

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        setupUser()
        setUserStatus(user.calculateBMI())
   }

    private fun setupUser() {
        user = User(
            intent.getDoubleExtra(R.string.height.toString(), 0.0),
            intent.getDoubleExtra(R.string.weight.toString(),0.0)
        )
    }

    private fun setUserStatus(status: String) {
        bmi_result.text = status
    }
}

