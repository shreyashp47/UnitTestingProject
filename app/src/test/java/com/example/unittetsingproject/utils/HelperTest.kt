package com.example.unittetsingproject.utils

import org.junit.Assert.*

import org.junit.Test

class HelperTest {

    @Test
    fun isPallidrome() {
        //Arrange
        var helper = Helper()

        //Act
        val result = helper.isPallidrome("hello")

        //Assert
        assertEquals(false, result)

    }

    @Test
    fun isPallidrome_inputString_lever_expectedTrue() {
        var helper = Helper()
        val result = helper.isPallidrome("level")
        assertEquals(true, result)
    }


}