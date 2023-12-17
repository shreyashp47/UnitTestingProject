package com.example.unittetsingproject.utils

class Helper {

    fun isPallidrome(input: String): Boolean {
        var i = 0
        var j = input.length-1
        var result = true
        while (i<j){
            if (input[i]   != input[j]){
                result = false
                break
            }
            i++
            j--
        }
        return result
    }
}