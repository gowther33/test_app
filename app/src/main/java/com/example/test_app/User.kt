package com.example.test_app

import java.io.Serializable

data class User(
    val name:String,
    val age:Int,
    val role:String
): Serializable

