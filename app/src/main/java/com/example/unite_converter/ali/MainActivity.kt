package com.example.unite_converter.ali

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.unite_converter.ali.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.edtInput.doAfterTextChanged {
            val userInput = it?.toString()?.toIntOrNull()
            val answer: Int = userInput?.let { celsiusToFahrenheit(userInput) } ?: 0
            if (answer == 0 || answer == 32)
                binding.txtFinalAnswer.text = " "
            else
                binding.txtFinalAnswer.text = "$answer Fahrenheit"
        }
    }

    private fun celsiusToFahrenheit(input: Int): Int {
        return ((input * 9 / 5) + 32)
    }
}