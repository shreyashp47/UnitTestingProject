package com.example.unittetsingproject.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class StringTest {

    @Test
    fun reverseStringIsEmpty() {
        val sut = Helper()
        val result = sut.reverseString("")
        assertEquals("",result)
    }

    @Test
    fun reverseStringSingle() {
        val sut = Helper()
        val result = sut.reverseString("a")
        assertEquals("a",result)
    }

    @Test
    fun reverseStringIsNotEmpty() {
        val sut = Helper()
        val result = sut.reverseString("level")
        assertEquals("level",result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun isStringNull() {
        val sut = Helper()
        val result = sut.reverseString(null)
    }
}