package com.example.buslive.data.model.response

data class AvailableBusesResponse(
    val Id: Int,
    val name: String,
    val code: String,
    val departure: Info,
    val arrival: Info,
    val terminal:String,
    val fare: Double

)

data class Info(
    val location: String,
    val date: String
)