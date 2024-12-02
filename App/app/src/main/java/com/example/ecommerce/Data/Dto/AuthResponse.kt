package com.example.ecommerce.Data.Dto

class AuthResponse(
     var status:String,
     var message:String,
     var token:String,
     var expiresIn:Int
) {
}