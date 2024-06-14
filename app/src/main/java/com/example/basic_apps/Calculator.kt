package com.example.basic_apps

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView

class Calculator : AppCompatActivity(), View.OnClickListener {
    private lateinit var etTinggi: EditText
    private lateinit var etLebar: EditText
    private lateinit var etPanjang: EditText
    private lateinit var etCalculate: Button
    private lateinit var etResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)
        etTinggi = findViewById(R.id.etTinggi)
        etLebar = findViewById(R.id.etLebar)
        etPanjang = findViewById(R.id.etPanjang)
        etCalculate = findViewById(R.id.etCalculate)
        etResult = findViewById(R.id.etResult)
        etCalculate.setOnClickListener(this)
        if(savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            etResult.text = result
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.etCalculate) {
            val inputPanjang = etPanjang.text.toString().trim()
            val inputLebar = etLebar.text.toString().trim()
            val inputTinggi = etTinggi.text.toString().trim()
            var isEmptyFields = false
            if (inputPanjang.isEmpty()) {
                isEmptyFields = true
                etPanjang.error = "Field ini tidak boleh kosong"
            }
            if (inputLebar.isEmpty()) {
                isEmptyFields = true
                etLebar.error = "Field ini tidak boleh kosong"
            }
            if (inputTinggi.isEmpty()) {
                isEmptyFields = true
                etTinggi.error = "Field ini tidak boleh kosong"
            }
            if (!isEmptyFields) {
                val volume = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                etResult.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, etResult.text.toString())
    }
}