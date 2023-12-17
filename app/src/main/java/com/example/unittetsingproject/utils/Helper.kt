package com.example.unittetsingproject.utils

class Helper {

    fun isPallidrome(input: String): Boolean {
        var i = 0
        var j = input.length - 1
        var result = true
        while (i < j) {
            if (input[i] != input[j]) {
                result = false
                break
            }
            i++
            j--
        }
        return result
    }

    fun validatePassword(input: String) = when {
        input.isBlank() -> {
            "Password is required field"
        }

        input.length < 8 -> {
            "Password must be at least 8 characters"
        }

        input.length > 20 -> {
            "Password must be less than 20 characters"
        }

        else -> {
            "Valid Password"
        }
    }


    fun reverseString(input: String?): String {
        if (input == null) {
            throw IllegalArgumentException("Input cannot be null")
        }
        var result = input.toCharArray()
        var i = 0
        var j = input.length - 1
        while (i < j) {
            var temp = result[i]
            result[i] = result[j]
            result[j] = temp
            i++
            j--
        }
        return result.joinToString("")
    }
}