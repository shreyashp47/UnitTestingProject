package com.example.unittetsingproject.roomtes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.unittetsingproject.room.QuoteDAO
import com.example.unittetsingproject.room.QuoteDatabase
import com.example.unittetsingproject.room.QuoteRoom
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuoteDaoTestCase {


    //Rule to execute all architecture component code
    // tasks synchronously
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    lateinit var quoteDAO: QuoteDAO
    lateinit var quoteRoom: QuoteRoom
    lateinit var quoteDatabase: QuoteDatabase

    @Before
    fun setUp() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()
        quoteDAO = quoteDatabase.quoteDAO

    }



    @Test
    fun insertQuote() = runBlocking{
        quoteRoom = QuoteRoom(1, "test", "test")
        quoteDAO.insert(quoteRoom)
        val result = quoteDAO.getAll().getOrAwaitValue()

        Assert.assertEquals(1, result.size)
        Assert.assertEquals("test", result[0].text)
    }
  @Test
    fun delteQuote() = runBlocking{
        quoteRoom = QuoteRoom(1, "test", "test")
        quoteDAO.insert(quoteRoom)
        quoteDAO.deleteAll()
        val result = quoteDAO.getAll().getOrAwaitValue()

        Assert.assertEquals(0, result.size)
    }

    @Before
    fun tearDown() {

        quoteDatabase.close()
    }
}