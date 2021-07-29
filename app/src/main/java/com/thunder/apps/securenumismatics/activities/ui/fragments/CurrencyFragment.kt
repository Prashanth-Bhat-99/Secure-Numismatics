package com.thunder.apps.securenumismatics.activities.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thunder.apps.securenumismatics.R
import android.widget.Button as Button1

class CurrencyFragment : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button1>(R.id.googleBtn).setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://calc-currency.herokuapp.com")
            startActivity(openURL)
        }
    }
}