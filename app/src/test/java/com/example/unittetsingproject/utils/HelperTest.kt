package com.example.unittetsingproject.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper: Helper

    @Before
    fun setUp() {
        //Arrange
        helper = Helper()
        println("Before Every Test case")
    }

    @After
    fun tearDown() {
     println("After Every Test case")
    }




    @Test
    fun isPallidrome() {

        //Act
        val result = helper.isPallidrome("hello")

        //Assert
        assertEquals(false, result)

    }

    @Test
    fun isPallidrome_inputString_lever_expectedTrue() {
        val result = helper.isPallidrome("level")
        assertEquals(true, result)
    }


}