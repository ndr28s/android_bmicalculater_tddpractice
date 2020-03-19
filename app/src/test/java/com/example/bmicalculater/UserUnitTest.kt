package com.example.bmicalculater

import junit.framework.Assert.*
import org.junit.Test

class UserUnitTest {

    @Test
    fun check_user_value() {
        val user = User(20.0, 20.0)
        assertEquals(20.0, user.weight)
        assertEquals(20.0, user.height)
    }

    @Test
    fun check_user_value_when_all_parameter_is_null() {
        val user = User(null, null)
        assertTrue(user.isUserNull())
    }

    @Test
    fun check_user_value_when_height_parameter_is_null() {
        val user = User(null, 10.0)
        assertTrue(user.isUserNull())
    }

    @Test
    fun check_user_value_when_weight_parameter_is_null() {
        val user = User(10.0, null)
        assertTrue(user.isUserNull())
    }

    @Test
    fun check_user_value_when_right_input() {
        val user = User(10.0, 10.0)
        assertFalse(user.isUserNull())
    }

    @Test
    fun check_bmi_when_user_is_null() {
        val user = User(null, null)
        assertEquals("잘못된 입력입니다", user.calculateBMI())
    }

    @Test
    fun check_bmi_when_height_is_null() {
        val user = User(null, 100.0)
        assertEquals("잘못된 입력입니다", user.calculateBMI())
    }

    @Test
    fun check_bmi_when_weight_is_null() {
        val user = User(100.0, null)
        assertEquals("잘못된 입력입니다", user.calculateBMI())
    }

    @Test
    fun check_bmi_when_user_height_is_bigger_then_weight() {
        val user = User(110.0, 100.0)
        assertEquals("저체중", user.calculateBMI())
    }

    @Test
    fun check_bmi_when_user_weight_is_bigger_then_height() {
        val user = User(100.0, 110.0)
        assertEquals("고체중", user.calculateBMI())
    }

    @Test
    fun check_bmi_when_user_height_and_weight_are_same() {
        val user = User(100.0, 100.0)
        assertEquals("정상체중", user.calculateBMI())
    }

    @Test
    fun check_bmi_when_user_height_and_weight_are_null() {
        val user = User(null, null)
        assertEquals("잘못된 입력입니다", user.calculateBMI())
    }

}