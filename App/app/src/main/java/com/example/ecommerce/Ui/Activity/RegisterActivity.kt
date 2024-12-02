package com.example.ecommerce.Ui.Activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ecommerce.Data.Api.AuthApiService
import com.example.ecommerce.Data.Api.RetrofitClient
import com.example.ecommerce.Data.Dto.AuthResponse
import com.example.ecommerce.Data.Model.User
import com.example.ecommerce.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RegisterActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var btnRegister: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        init()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun init() {
        email = findViewById(R.id.email)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        firstName = findViewById(R.id.first_name)
        lastName = findViewById(R.id.last_name)
        btnRegister = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener(View.OnClickListener {
            var user:User = User(username.text.toString(), password.text.toString(), firstName.text.toString(), lastName.text.toString(), "", "", "")
            register(user)
        })
    }
    private fun register(user: User) {
        var retrofitClient:RetrofitClient = RetrofitClient()
        retrofitClient.instance.register(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(
                call: Call<AuthResponse>,
                response: Response<AuthResponse>
            ) {
//                if (response.isSuccessful && response.body()?.success == true) {
//                    Toast.makeText(this@RegisterActivity, "Đăng ký thành công!", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this@RegisterActivity, "Đăng ký thất bại!", Toast.LENGTH_SHORT).show()
//                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Lỗi: ${t.message}", Toast.LENGTH_SHORT).show()
                System.out.println(t.message)
            }
        })
    }
}