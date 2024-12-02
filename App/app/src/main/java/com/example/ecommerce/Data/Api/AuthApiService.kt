package com.example.ecommerce.Data.Api

import com.example.ecommerce.Data.Dto.AuthRequest
import com.example.ecommerce.Data.Dto.AuthResponse
import com.example.ecommerce.Data.Model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthApiService {
    @POST("/auth/login")
    fun login(@Body authRequest: AuthRequest?): Call<AuthResponse>

    @POST("/auth/register")
    fun register(@Body user: User?): Call<AuthResponse>
}