package com.example.challengemodeloparcial.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.challengemodeloparcial.R
import com.example.challengemodeloparcial.activities.SettingsActivity

class ProfileFragment : Fragment() {

    lateinit var v: View
    lateinit var btn_profile: Button
    private lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_profile, container, false)

        btn_profile = v.findViewById(R.id.id_profile_setting)

        appContext = findNavController().context

        return v
    }

    override fun onStart() {
        super.onStart()

        btn_profile.setOnClickListener {
            val intent = Intent(appContext, SettingsActivity::class.java)

            startActivity(intent)
        }
    }

}