package com.example.unittetsingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val msg = intent.getStringExtra("quote")
        findViewById<TextView>(R.id.msg).text = msg
    }
}