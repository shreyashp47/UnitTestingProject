package com.example.unittetsingproject

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteList(context,"")

    }
    @Test(expected = JsonSyntaxException::class)
    fun populateQuoteFromAssetsInvalidJsonExpected() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteList(context,"InvalidJsonQuote.json")

    }
    @Test
    fun populateQuoteFromAssetsCount() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteList(context,"Quote.json")
        assertEquals(6,quoteManager.quoteList.size) // 6 quotes()

    }


    @Test
    fun testPreviostQuote() {
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote(
                    "If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough.","1"
                ),
                Quote("The only way to do great work is to love what you do.","2"),
                Quote("Success is not final; failure is not fatal: it is the courage to continue that counts.","3"),

            ))
            val quote = quoteManager.getPreviousQuote()
            assertEquals("1",quote.author)

    }

    @Test
    fun testNextQuote() {
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote(
                    "If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough.","1"
                ),
                Quote("The only way to do great work is to love what you do.","2"),
                Quote("Success is not final; failure is not fatal: it is the courage to continue that counts.","3"),

            ))
            val quote = quoteManager.getNextQuote()
            assertEquals("2",quote.author)

    }
}