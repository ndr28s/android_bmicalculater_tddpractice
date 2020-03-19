package com.example.bmicalculater

import android.content.Intent
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.activity_result.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@Config(sdk = [android.os.Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class ResultActivityUITest {

    lateinit var resultActivity: ResultActivity
    @Before
    fun setup() {
        resultActivity = Robolectric.buildActivity(ResultActivity::class.java).setup().get()
    }

    @Test
    fun bmi_result_when_user_weight_is_bigger_then_height() {
        val intent = Intent(
            Robolectric.buildActivity(MainActivity::class.java).setup().get(),
            MainActivity::class.java
        )
        intent.putExtra(R.string.height.toString(), 110.0)
        intent.putExtra(R.string.weight.toString(), 120.0)

        val resultActivity: ResultActivity = Robolectric.buildActivity(ResultActivity::class.java, intent).create().get()

        assertEquals("고체중", resultActivity.bmi_result.text)
    }

    @Test
    fun bmi_result_when_user_height_is_bigger_then_weight() {
        val intent = Intent(
            Robolectric.buildActivity(MainActivity::class.java).setup().get(),
            MainActivity::class.java
        )
        intent.putExtra(R.string.height.toString(), 120.0)
        intent.putExtra(R.string.weight.toString(), 110.0)

        val resultActivity: ResultActivity = Robolectric.buildActivity(ResultActivity::class.java, intent).create().get()

        assertEquals("저체중", resultActivity.bmi_result.text)
    }

    @Test
    fun bmi_result_when_user_height_and_weight_same() {
        val intent = Intent(
            Robolectric.buildActivity(MainActivity::class.java).setup().get(),
            MainActivity::class.java
        )
        intent.putExtra(R.string.height.toString(), 110.0)
        intent.putExtra(R.string.weight.toString(), 110.0)

        val resultActivity: ResultActivity = Robolectric.buildActivity(ResultActivity::class.java, intent).create().get()

        assertEquals("정상체중", resultActivity.bmi_result.text)
    }
}