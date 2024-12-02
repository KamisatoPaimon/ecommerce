package com.example.ecommerce.Authentication

import com.example.ecommerce.Data.Api.AuthApiService
import com.example.ecommerce.Data.Api.RetrofitClient
import com.example.ecommerce.Data.Dto.AuthRequest
import com.example.ecommerce.Data.Dto.AuthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Auth {
    private var authResponse: AuthResponse? = null

    fun login(authRequest: AuthRequest, callback: (Boolean, String?) -> Unit) {
        val retrofitClient = RetrofitClient().getClient().create(AuthApiService::class.java)
        val call = retrofitClient.login(authRequest)

        // Gọi API bất đồng bộ
        call.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    authResponse = response.body()
                    callback(true, null) // Đăng nhập thành công
                } else {
                    callback(false, "Invalid credentials or server error")
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                callback(false, t.message) // Xử lý lỗi khi không kết nối được
            }
        })
    }

    fun isAuthenticated(): Boolean {
        return authResponse?.status == "201"
    }
}
