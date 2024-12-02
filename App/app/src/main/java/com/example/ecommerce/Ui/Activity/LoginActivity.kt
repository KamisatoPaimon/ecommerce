package com.example.ecommerce.Ui.Activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ecommerce.Authentication.Auth
import com.example.ecommerce.Data.Api.RetrofitClient
import com.example.ecommerce.Data.Dto.AuthRequest
import com.example.ecommerce.R


class LoginActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password:EditText
    private lateinit var btn_login: Button
    private lateinit var retrofitClient: RetrofitClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        init()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun init() {
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        btn_login = findViewById(R.id.btn_login)
        btn_login.setOnClickListener {
            login();
        }
    }

    fun login() {
        // Khởi tạo Auth
        val auth = Auth()
        // Tạo AuthRequest với dữ liệu từ người dùng
        val authRequest = AuthRequest(username.text.toString(), password.text.toString())

        // Gọi phương thức login
        auth.login(authRequest) { isSuccess, errorMessage ->
            if (isSuccess) {
                // Xử lý khi đăng nhập thành công
                println("Login successful!")
            } else {
                // Xử lý khi đăng nhập thất bại
                println("Login failed: $errorMessage")
            }
        }
    }


}