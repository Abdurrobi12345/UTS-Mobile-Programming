package com.abdurrobi.loginactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.util.Log

import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            // Contoh validasi sederhana
            if (username == "abdurrobi elman sudri" && password == "admin123") {
                // Login berhasil
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()

                // Navigasi ke halaman baru (MainActivity)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Log.d("LoginActivity", "Navigasi ke MainActivity") // Tambahkan pesan log


                // Menutup LoginActivity
                finish()
            } else {
                // Login gagal
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
