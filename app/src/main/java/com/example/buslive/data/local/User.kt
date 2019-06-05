package com.example.buslive.data.local

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tbl_users")
data class User(
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "pkId")
    val pkId: Int,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "phone")
    val phone: String
)