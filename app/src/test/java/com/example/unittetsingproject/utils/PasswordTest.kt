package com.example.unittetsingproject.utils

import org.junit.Assert.*
import org.junit.Test


class PasswordTest {

    @Test
    fun validatePasswordBlankInput() {
        val sut = Helper()
        val result = sut.validatePassword("   ")
        assertEquals("Password is required field",result)
    }


    @Test
    fun validatePasswordLessThan() {
        val sut = Helper()
        val result = sut.validatePassword("a ")
        assertEquals("Password must be at least 8 characters",result)
    }
    @Test
    fun validatePasswordGreaterThan() {
        val sut = Helper()
        val result = sut.validatePassword("urwhfuiwrhufhui whfew gfhwerjfhui")
        assertEquals("Password must be less than 20 characters",result)
    }
    @Test
    fun validatePasswordValud() {
        val sut = Helper()
        val result = sut.validatePassword("shreyash")
        assertEquals("Valid Password",result)
    }
}