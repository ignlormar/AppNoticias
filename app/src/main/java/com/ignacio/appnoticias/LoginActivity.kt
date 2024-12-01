package com.ignacio.appnoticias

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ignacio.appnoticias.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val PREFS_NAME = "UserPrefs"
    private val KEY_FIRST_TIME = "sp_first_time"
    private val KEY_USERNAME = "username"
    private val KEY_PASSWORD = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time),true)
        Log.i("SP", "sp_first_time = $isFirstTime")

        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bgLogin("https://e0.pxfuel.com/wallpapers/486/639/desktop-wallpaper-tracks-race-track.jpg")

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.loginBtn.setOnClickListener{

            val username = binding.etUsuario.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()


            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this,
                    "Ambos campos son obligatorios.",
                    Toast.LENGTH_SHORT)
                    .show()

                return@setOnClickListener
            }

            if (isFirstTime) {
                preferences.edit().apply {
                    putBoolean(KEY_FIRST_TIME, false)
                    putString(KEY_USERNAME, username)
                    putString(KEY_PASSWORD, password)
                    apply()
                }
                Toast.makeText(this,
                    "Usuario registrado.",
                    Toast.LENGTH_SHORT)
                    .show()

                navigateToMainActivity()
            } else {
                val savedUsername = preferences.getString(KEY_USERNAME, null)
                val savedPassword = preferences.getString(KEY_PASSWORD, null)

                if (username == savedUsername && password == savedPassword){
                    Toast.makeText(this,
                        "Bienvendido $username!",
                        Toast.LENGTH_SHORT)
                        .show()
                    navigateToMainActivity()
                } else {
                    Toast.makeText(this,
                        "Usuario o contraseña incorrectos.",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun bgLogin(url: String){
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.loginBg)
    }

    private fun navigateToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}