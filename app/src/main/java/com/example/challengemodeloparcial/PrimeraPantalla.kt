package com.example.challengemodeloparcial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputEditText

class PrimeraPantalla : Fragment() {

    private lateinit var v: View
    private lateinit var buttonStart: Button
    private lateinit var textName: TextInputEditText
    private lateinit var textPasswd: TextInputEditText
    private lateinit var getPass: String
    private lateinit var getNombre: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_primera_pantalla, container, false)

        buttonStart = v.findViewById(R.id.id_button_start)

        textPasswd = v.findViewById(R.id.editTextNamePw)
        textName = v.findViewById(R.id.editTextName)

        return v
    }

    override fun onStart() {
        super.onStart()

        buttonStart.setOnClickListener {
            getPass = textPasswd.text.toString()
            getNombre = textName.text.toString()

            when {
                getNombre.isEmpty() || getPass.isEmpty() -> {
                    Toast.makeText(activity, "Los campos son obligatorios", Toast.LENGTH_SHORT)
                        .show()
                }
                else -> {
                    Toast.makeText(activity, "Access Success", Toast.LENGTH_SHORT)
                        .show()

                    var a = PrimeraPantallaDirections.actionPrimeraPantallaToListProductFragment(
                        getNombre
                    )

                    v.findNavController().navigate(a)
                }
            }
        }
    }


}