package com.example.unittetsingproject

import android.content.Context
import com.google.gson.Gson

class QuoteManager {
    var quoteList = emptyArray<Quote>()
    var currentQuoteIndex = 0

    fun populateQuoteList(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList = gson.fromJson(json, Array<Quote>::class.java)


    }

    fun populateQuotes(quote: Array<Quote>) {
        quoteList = quote
    }

    fun getNextQuote(): Quote {
        if (currentQuoteIndex == quoteList.size - 1)
            return quoteList[currentQuoteIndex]
        return quoteList[++currentQuoteIndex]


    }

    fun getPreviousQuote(): Quote {
        if (currentQuoteIndex == 0) {
            return quoteList[currentQuoteIndex]
        } else
            return quoteList[--currentQuoteIndex]
    }

    fun getCurrentQuote(): Quote {
        return quoteList[currentQuoteIndex]
    }


}