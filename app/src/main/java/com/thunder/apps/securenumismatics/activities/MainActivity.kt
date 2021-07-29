package com.thunder.apps.securenumismatics.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thunder.apps.securenumismatics.databinding.ActivityMainBinding
import com.thunder.apps.securenumismatics.utils.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences(Constants.MY_SHOP_PAL_PREFERENCES, Context.MODE_PRIVATE)
        val userName = sharedPref.getString(Constants.LOGGED_IN_USERNAME,"Hello")

        binding.userName.text = userName.toString()
    }
}