package com.example.biodata

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        val nama = intent.getStringExtra("nama")
        val alamat = intent.getStringExtra("alamat")
        val tanggal = intent.getStringExtra("tanggal")
        val kelamin = intent.getStringExtra("kelamin")
        val agama = intent.getStringExtra("agama")

        val hasil = """
            Nama: $nama
            Alamat: $alamat
            Tanggal Lahir: $tanggal
            Jenis Kelamin: $kelamin
            Agama: $agama
        """.trimIndent()

        tvHasil.text = hasil
    }
}
