package com.example.yourapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uid: Int,
    val firstName: String?,
    val lastName: String?
)
