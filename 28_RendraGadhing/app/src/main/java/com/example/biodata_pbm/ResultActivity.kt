package com.example.biodata_pbm
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity(){
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvHasil = findViewById(R.id.tvHasil)

        val nama = intent.getStringExtra("NAMA")
        val alamat = intent.getStringExtra("ALAMAT")
        val tanggal = intent.getStringExtra("TANGGAL")
        val gender = intent.getStringExtra("GENDER")
        val agama = intent.getStringExtra("AGAMA")

        tvHasil.text = """
            Nama:$nama
            Alamat: $alamat
            Tanggal Lahir: $tanggal
            Jenis Kelamin: $gender
            Agama: $agama
            
            
            Yoroshiku $nama Watashi wa Rendra Desu!!
        """.trimIndent()
    }
}