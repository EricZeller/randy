package de.ericz.tippy

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun generateRandomNumber(view: View) {
        val from = findViewById<EditText>(R.id.from)
        val aFrom = from.text.toString()
        val to = findViewById<EditText>(R.id.to)
        val aTo = to.text.toString()
        var firstGeneration = true

        if (aFrom.isNotEmpty() && aTo.isNotEmpty() && (aFrom <= aTo)) {
            val pFrom = aFrom.toInt()
            val pTo = aTo.toInt()
            val randomNumberTextView = findViewById<TextView>(R.id.textViewResult)
            val randomNumber = (pFrom..pTo).random()
            randomNumberTextView.text = "$randomNumber"
            Toast.makeText(this, "Generated!", Toast.LENGTH_SHORT).show()
            firstGeneration = false
        } else {
            Toast.makeText(this, "Please insert a valid number", Toast.LENGTH_SHORT).show()
        }

        if (!firstGeneration) {
            findViewById<Button>(R.id.buttonNew).text = "New one"
        }

    }
}