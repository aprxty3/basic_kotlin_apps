package com.example.basic_apps

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.button_move)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithData: Button = findViewById(R.id.button_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.button_move_with_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.button_dial_number)
        btnDialPhone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_move -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.button_move_with_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithData::class.java)
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

                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObject::class.java)
                moveWithObjectIntent.putExtra(MoveWithObject.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.button_dial_number -> {
                val phoneNumber = "081210841083"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}