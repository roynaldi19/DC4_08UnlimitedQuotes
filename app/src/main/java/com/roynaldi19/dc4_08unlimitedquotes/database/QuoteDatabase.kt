package com.roynaldi19.dc4_08unlimitedquotes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.roynaldi19.dc4_08unlimitedquotes.network.QuoteResponseItem

@Database(
    entities = [QuoteResponseItem::class],
    version = 1,
    exportSchema = false
)
abstract class QuoteDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): QuoteDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    QuoteDatabase::class.java, "quote_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}