package com.example.unittetsingproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: EditText
        get() = findViewById(R.id.quoteAuthor)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(application)
        ).get(MainViewModel::class.java)
        setQuote(mainViewModel.getQuote())

    }

    fun setQuote(quote: Quote) {
        quoteText.text = quote.text
        //quoteAuthor.setText(quote.author)
    }

    fun onPrevious(view: View) {
        //toPreviousQuote()
        //setQuote(mainViewModel.previousQuote())
        //notSecondActivity()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("quote",quoteAuthor.text.toString())
        startActivity(intent)
    }

    fun onNext(view: View) {
        setQuote(mainViewModel.nextQuote())
    }

    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().text)
        startActivity(intent)
    }

}