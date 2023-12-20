package com.example.unittetsingproject.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface QuoteDAO {

    @Insert
    suspend fun insert(quoteRoom: QuoteRoom)

    @Update
    suspend fun update(quoteRoom: QuoteRoom)

    @Query("DELETE FROM QuoteRoom")
   suspend fun deleteAll()

    @Query("SELECT * FROM QuoteRoom")
    fun getAll(): LiveData<List<QuoteRoom>>


//    @Query("SELECT * FROM QuoteRoom WHERE id = :key")
//    suspend fun getQuoteById(key: Int): QuoteRoom

}