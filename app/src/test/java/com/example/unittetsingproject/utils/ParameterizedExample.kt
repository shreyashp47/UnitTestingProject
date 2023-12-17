package com.example.unittetsingproject.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedExample(val input: String, val expectedValue: Boolean) {

    @Test
    fun test() {
        val helper = Helper()
        val result = helper.isPallidrome(input)
        assertEquals(expectedValue, result)
    }


    companion object {
        @JvmStatic
        @Parameterized.Parameters(name ="{index}: {0} is pallidrome: {1}" )
        fun data(): List<Array<Any>> {

            return listOf(
                arrayOf("hello", true),
                arrayOf("level", true),
                arrayOf("", true),
                arrayOf("a", true)
            )
        }
    }
}