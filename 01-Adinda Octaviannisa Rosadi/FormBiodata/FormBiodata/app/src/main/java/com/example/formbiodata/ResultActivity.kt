package com.example.formbiodata

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

        val hasil = "Nama : $nama\nAlamat : $alamat\nTanggal : $tanggal\nGender : $gender\nAgama : $agama"
        findViewById<TextView>(R.id.tvHasil).text = hasil
    }
}