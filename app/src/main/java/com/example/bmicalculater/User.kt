package com.example.bmicalculater

class User {
    val height: Double?
    val weight: Double?

    constructor(height: Double?, weight: Double?) {
        this.height = height
        this.weight = weight
    }

    fun isUserNull(): Boolean {
        return (height == null || weight == null)
    }

    fun calculateBMI(): String {
        if (isUserNull()) {
            return "잘못된 입력입니다"
        } else {
            val bmi = height!! / weight!!

            return when {
                bmi > 1.0 -> "저체중"
                bmi == 1.0 -> "정상체중"
                else -> "고체중"
            }
        }
    }
}