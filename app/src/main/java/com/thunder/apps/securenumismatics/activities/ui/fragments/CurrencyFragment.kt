package com.thunder.apps.securenumismatics.activities.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thunder.apps.securenumismatics.R
import com.thunder.apps.securenumismatics.databinding.FragmentCurrencyBinding
import android.widget.Button as Button1

class CurrencyFragment : AppCompatActivity(){
    private lateinit var binding: FragmentCurrencyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentCurrencyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findViewById<Button1>(R.id.googleBtn).setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://calc-currency.herokuapp.com")
            startActivity(openURL)
        }
    }
}