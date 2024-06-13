package com.example.basic_apps

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etTinggi: EditText
    private lateinit var etLebar: EditText
    private lateinit var etPanjang: EditText
    private lateinit var etCalculate: Button
    private lateinit var etResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etTinggi = findViewById(R.id.etTinggi)
        etLebar = findViewById(R.id.etLebar)
        etPanjang = findViewById(R.id.etPanjang)
        etCalculate = findViewById(R.id.etCalculate)
        etResult = findViewById(R.id.etResult)
        etCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.etCalculate) {
            val inputPanjang = etPanjang.text.toString().trim()
            val inputLebar = etLebar.text.toString().trim()
            val inputTinggi = etTinggi.text.toString().trim()
            val volume = inputLebar.toDouble() * inputPanjang.toDouble() * inputTinggi.toDouble()
            etResult.text = volume.toString()
        }
    }
}