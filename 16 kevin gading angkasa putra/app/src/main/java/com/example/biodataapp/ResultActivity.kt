package com.example.biodataapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ambil data dari intent
        val nama = intent.getStringExtra("nama") ?: ""
        val alamat = intent.getStringExtra("alamat") ?: ""
        val tgl = intent.getStringExtra("tgl") ?: ""
        val gender = intent.getStringExtra("gender") ?: ""
        val agama = intent.getStringExtra("agama") ?: ""

        setContent {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Hasil Biodata:", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(8.dp))
                Text("Nama: $nama")
                Text("Alamat: $alamat")
                Text("Tanggal Lahir: $tgl")
                Text("Jenis Kelamin: $gender")
                Text("Agama: $agama")
            }
        }
    }
}
