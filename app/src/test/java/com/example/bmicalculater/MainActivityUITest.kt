package com.example.bmicalculater

import android.content.Intent
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowToast


@Config(sdk = [android.os.Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class MainActivityUITest {
    lateinit var mainActivity: MainActivity

    @Before
    fun setup() {
        mainActivity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
    }


    @Test
    fun user_data_input() {
        mainActivity.user_height.setText("123")
        mainActivity.user_weight.setText("123")
        mainActivity.result_button.performClick()

        val mainActivityShadow = shadowOf(mainActivity)
        val expectedActivity = Intent(mainActivity, ResultActivity::class.java)
        val actualActivity = mainActivityShadow.nextStartedActivity

        assertEquals(expectedActivity.component, actualActivity.component)
    }

    @Test
    fun result_button_click_without_value() {
        mainActivity.result_button.performClick()

        assertEquals("키를 입력해 주세요", ShadowToast.getTextOfLatestToast())
    }

    @Test
    fun result_button_click_without_weightvalue() {

        mainActivity.user_height.setText("123")
        mainActivity.result_button.performClick()

        assertEquals("몸무게를 입력해 주세요", ShadowToast.getTextOfLatestToast())
    }
}