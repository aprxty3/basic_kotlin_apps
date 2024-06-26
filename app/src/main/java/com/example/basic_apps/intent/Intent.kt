package com.example.basic_apps.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.basic_apps.R

class Intent : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == MoveForResult.RESULT_CODE) {
            val selectedValue = result.data?.getIntExtra(MoveForResult.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil: $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_activity)

        val btnMoveActivity: Button = findViewById(R.id.button_move)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithData: Button = findViewById(R.id.button_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.button_move_with_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.button_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)
        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_move -> {
                val moveIntent = Intent(this@Intent, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.button_move_with_data -> {
                val moveWithDataIntent = Intent(this@Intent, MoveWithData::class.java)
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_NAME, "DicodingAcademy")
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }

            R.id.button_move_with_object -> {
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "Ajiii",
                    "Bandung"
                )

                val moveWithObjectIntent = Intent(this@Intent, MoveWithObject::class.java)
                moveWithObjectIntent.putExtra(MoveWithObject.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.button_dial_number -> {
                val phoneNumber = "081210841083"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@Intent, MoveForResult::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }
}