package com.example.buslive.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.buslive.data.dao.IUserDao
import com.example.buslive.data.local.User

@Database(entities = [(User::class)], version = 1)
abstract class BusLiveDB : RoomDatabase() {

    abstract fun userDao(): IUserDao

    companion object {
        private var mInstance: BusLiveDB? = null
        val DATABASE_NAME = "BUSLIVEDB"

        fun getInstance(context: Context): BusLiveDB {
            if (mInstance == null) mInstance = Room.databaseBuilder(context, BusLiveDB::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
            return mInstance!!
        }
    }


}