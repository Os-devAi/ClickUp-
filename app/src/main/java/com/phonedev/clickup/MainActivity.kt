package com.phonedev.clickup

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.phonedev.clickup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        click()
    }

    private fun click() {
        binding.btnClick.setOnClickListener {
            val code = binding.txtCode.text.trim()
            val number = binding.txtNumber.text.trim()
            disableUI()
            if (code.isNotEmpty() && number.isNotEmpty()) {
                sendMessage()
                enableUI()
            } else {
                Toast.makeText(this, "Check your code or number!", Toast.LENGTH_SHORT).show()
                enableUI()
            }
        }
        binding.imgWhatsappLogo.setOnClickListener {
            val code = binding.txtCode.text.trim()
            val number = binding.txtNumber.text.trim()
            disableUI()
            if (code.isNotEmpty() && number.isNotEmpty()) {
                sendMessage()
                enableUI()
            } else {
                Toast.makeText(this, "Check your code or number!", Toast.LENGTH_SHORT).show()
                enableUI()
            }
        }
    }

    //open chat
    private fun sendMessage() {
        val message = binding.txtMessage.text.toString().trim()
        val code = binding.txtCode.text.trim()
        val number = binding.txtNumber.text.trim()

        val url = "https://wa.me/$code$number?text=$message"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun enableUI() {
        binding.btnClick.isEnabled = true
        binding.txtCode.isEnabled = true
        binding.txtNumber.isEnabled = true
        binding.txtMessage.isEnabled = true
    }

    private fun disableUI() {
        binding.btnClick.isEnabled = false
        binding.txtCode.isEnabled = false
        binding.txtNumber.isEnabled = false
        binding.txtMessage.isEnabled = false
    }
}