package com.example.biodata_form

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val nama = intent.getStringExtra("nama")
        val alamat = intent.getStringExtra("alamat")
        val tanggal = intent.getStringExtra("tanggal")
        val gender = intent.getStringExtra("gender")
        val agama = intent.getStringExtra("agama")

        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        tvHasil.text = getString(
            R.string.hasil_format,
            nama,
            alamat,
            tanggal,
            gender,
            agama
        )
    }
}
