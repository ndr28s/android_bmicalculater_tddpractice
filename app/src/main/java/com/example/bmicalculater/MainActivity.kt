package com.example.bmicalculater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    private lateinit var userHeight: String
//    private lateinit var userWeight: String

    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result_button.setOnClickListener {

            val isUserInputCorrect = checkUserInput()
            if (isUserInputCorrect) {
                setUserInfo()
                moveToResultPage()
            }
        }

    }

    private fun setUserInfo() {
        user = User(
            user_height.text.toString().toDouble(),
            user_weight.text.toString().toDouble()
        )
    }

    private fun checkUserInput(): Boolean {
        if(user_height.text.toString().isEmpty()) {
            Toast.makeText(applicationContext, "키를 입력해 주세요", Toast.LENGTH_SHORT).show()
            return false
        }
        if (user_weight.text.toString().isEmpty()) {
            Toast.makeText(applicationContext, "몸무게를 입력해 주세요", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun moveToResultPage() {
        val resultActivityIntent = Intent(this, ResultActivity::class.java)
        resultActivityIntent.putExtra(R.string.height.toString(), user.height)
        resultActivityIntent.putExtra(R.string.weight.toString(), user.weight)
        startActivity(resultActivityIntent)
    }
}
