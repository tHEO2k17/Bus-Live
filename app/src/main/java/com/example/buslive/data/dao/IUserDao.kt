package com.example.buslive.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.buslive.data.local.User

@Dao
interface IUserDao {
    @Insert
    fun insert(user: User)
}