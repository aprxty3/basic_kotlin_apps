package com.example.basic_apps.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.basic_apps.R

class DebugAndLog : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView

    private var names = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.debug_log)

        tvText = findViewById(R.id.tv_text)
        btnSetValue = findViewById(R.id.btn_set_value)

        btnSetValue.setOnClickListener(this)

        names.add("Dicoding")
        names.add("Academy")
        names.add("Indonesia")
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_set_value) {
            Log.d("MainActivity", names.toString())
            val name = StringBuilder()
            for (i in 0 until names.size) {
                name.append(names[i]).append("\n")
            }
            tvText.text = name.toString()
        }
    }
}