package com.example.unittetsingproject.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuoteRoom::class], version = 1)
abstract  class QuoteDatabase : RoomDatabase(){

    abstract val quoteDAO: QuoteDAO

}