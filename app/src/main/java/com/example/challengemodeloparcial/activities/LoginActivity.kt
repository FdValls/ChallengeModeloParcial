package com.example.challengemodeloparcial.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.challengemodeloparcial.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var v: View
    private lateinit var buttonStart: Button
    private lateinit var textName: TextInputEditText
    private lateinit var textPasswd: TextInputEditText
    private lateinit var getPass: String
    private lateinit var getNombre: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonStart = findViewById(R.id.id_button_start)
        textPasswd = findViewById(R.id.editTextNamePw)
        textName = findViewById(R.id.editTextName)

    }

    override fun onStart() {
        super.onStart()

        buttonStart.setOnClickListener {
            getPass = textPasswd.text.toString()
            getNombre = textName.text.toString()

            when {
                getNombre.isEmpty() || getPass.isEmpty() -> {
                    Toast.makeText(this, "Los campos son obligatorios", Toast.LENGTH_SHORT)
                        .show()
                }
                else -> {
                    Toast.makeText(this, "Access Success", Toast.LENGTH_SHORT)
                        .show()

                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }
    }
}