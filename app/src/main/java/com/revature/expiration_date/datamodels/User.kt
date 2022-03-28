package com.revature.expiration_date.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "User_list")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    val email:String,

    val name:String,

    val password:String

)
